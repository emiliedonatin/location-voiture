package fr.treeptik.locationvoiture.dao;

import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Client;

public interface ClientDAO {
	
	Client save (Client client) throws DAOException;
	Client update (Client client) throws DAOException;
	void remove (Client client) throws DAOException;
	List<Client> findAll() throws DAOException;
	Client findById(Integer id) throws DAOException;
}
