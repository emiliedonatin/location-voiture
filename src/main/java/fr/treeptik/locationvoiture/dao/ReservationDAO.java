package fr.treeptik.locationvoiture.dao;

import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Reservation;

public interface ReservationDAO {
	
	Reservation save (Reservation reservation) throws DAOException;
	Reservation update (Reservation reservation) throws DAOException;
	void remove (Reservation reservation) throws DAOException;
	List<Reservation> findAll() throws DAOException;
	Reservation findById(Integer id) throws DAOException;

}
