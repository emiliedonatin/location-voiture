package fr.treeptik.locationvoiture.service;

import java.util.List;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;

public interface ClientService {
	
	Client save (Client client) throws ServiceException;
	Client update (Client client) throws ServiceException;
	void remove (Client client) throws ServiceException;
	List<Client> findAll() throws ServiceException;
	Client findById (Integer id) throws ServiceException;

}
