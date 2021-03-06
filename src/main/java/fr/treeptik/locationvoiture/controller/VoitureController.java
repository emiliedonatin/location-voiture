package fr.treeptik.locationvoiture.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;
import fr.treeptik.locationvoiture.validator.VoitureValidator;

@Controller
public class VoitureController {

	@Autowired
	private VoitureService voitureService;

	@Autowired
	private VoitureValidator voitureValidator;

	@RequestMapping("/hello")
	public void sayHello() {

		// c'est juste pour tester la connection
		System.out.println("Hello World");

	}

	@RequestMapping(value = "/voiture.do", method = RequestMethod.GET)
	public ModelAndView initForm() {

		Voiture v = new Voiture();

		// On retourne ensuite sur une page qui nous permet de remplir la
		// voiture
		ModelAndView modelAndView = new ModelAndView("saisie-voiture", "voiture", v);

		return modelAndView;

	}

	@RequestMapping(value = "/voiture.do", method = RequestMethod.POST)
	public ModelAndView saisieVoiture(@Valid Voiture voiture, BindingResult errors) throws ServiceException {
		// le @Valid sert à valider les annotations qu'on a dans le POJO voiture
		// Le bindingresult récupère les données si la saisie est incorrecte

		voitureValidator.validate(voiture, errors);

		if (errors.hasErrors()) {
			return new ModelAndView("saisie-voiture", "voiture", voiture);

		}

		System.out.println("Voiture marque : " + voiture.getMarque());
		System.out.println("Voiture modele : " + voiture.getModele());

		voitureService.save(voiture);

		return new ModelAndView("redirect:voitures.do");

	}

	@RequestMapping(value = "/voitures.do", method = RequestMethod.GET)
	public ModelAndView findAll() throws ServiceException {

		// Si on veut passer plusieurs paramètres dans la liste on peut faire
		// aussi une map

		// Map<String, Object> params = new HashMap<String, Object>();
		// params.put("voitures", voitureService.findAll());
		// params.put("supervoiture", new Voiture(5, "Super Voiture",
		// "Modele de Ouf"));
		//
		// return new ModelAndView("list-voiture", params);

		return new ModelAndView("list-voiture", "voitures", voitureService.findAll());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(Voiture voiture) throws ServiceException {

		voitureService.remove(voiture);

		return "redirect:voitures.do";

	}

	@RequestMapping(value = "/modifier.do", method = RequestMethod.GET)
	public ModelAndView initModifier(Voiture voiture) throws ServiceException {

		voiture = voitureService.findById(voiture.getId());

		return new ModelAndView("modifier-voiture", "voiture", voiture);

	}

	@RequestMapping(value = "/modifier.do", method = RequestMethod.POST)
	public ModelAndView modifier(@Valid Voiture voiture, BindingResult errors) throws ServiceException {

		if (errors.hasErrors()) {
			return new ModelAndView("modifier-voiture", "voiture", voiture);

		}

		voitureService.update(voiture);

		return new ModelAndView("redirect:voitures.do");
	}

}
