package fr.treeptik.locationvoiture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	@Transactional
	public Client save(Client client) throws ServiceException {
		try {
			clientDAO.save(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return client;
	}

	@Override
	@Transactional
	public Client update(Client client) throws ServiceException {
		try {
			client = clientDAO.update(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return client;
	}

	@Override
	@Transactional
	public void remove(Client client) throws ServiceException {
		try {
			clientDAO.remove(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public List<Client> findAll() throws ServiceException {

		List<Client> clients = new ArrayList<>();
		
		try {
			clients = clientDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return clients;
	}

	@Override
	public Client findById(Integer id) throws ServiceException {

		Client client= null;
		
		try {
			client = clientDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return client;
	}

}
