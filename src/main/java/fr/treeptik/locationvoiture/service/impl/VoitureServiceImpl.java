package fr.treeptik.locationvoiture.service.impl;

import java.util.ArrayList;
import java.util.List;

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
			throw new ServiceException(e.getMessage(), e);
		}
		return voiture;
	}

	@Override
	@Transactional
	public void remove(Voiture voiture) throws ServiceException {
		
		try {
			voitureDAO.remove(voiture);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
		
	}

	@Override
	public List<Voiture> findAll() throws ServiceException {
		
		List<Voiture> voitures = new ArrayList<>();
		
		try {
			voitures = voitureDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return voitures;
	}

	@Override
	@Transactional
	public Voiture update(Voiture voiture) throws ServiceException {
		
		try {
			voiture = voitureDAO.update(voiture);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
		return voiture;
	}

	@Override
	public Voiture findById(Integer id) throws ServiceException {
		Voiture voiture = null;
		
		try {
			voiture = voitureDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return voiture;
	}
	
	
	

}
