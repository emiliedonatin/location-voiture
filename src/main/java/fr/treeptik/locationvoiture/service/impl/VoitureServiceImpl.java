package fr.treeptik.locationvoiture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;

@Service
public class VoitureServiceImpl implements VoitureService {
	
	@Autowired
	private VoitureDAO voitureDAO;
	
	@Override
	@Transactional
	public Voiture save(Voiture voiture) throws ServiceException {
		try {
			voitureDAO.save(voiture);
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}
		return voiture;
	}

	@Override
	@Transactional
	public void remove(Voiture voiture) throws ServiceException {
		
		try {
			voitureDAO.remove(voiture);
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}
		
		
	}

	@Override
	public List<Voiture> findAll() throws ServiceException {
		
		List<Voiture> voitures = new ArrayList<>();
		
		try {
			voitures = voitureDAO.findAll();
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}
		return voitures;
	}
	
	
	

}
