package fr.treeptik.locationvoiture.service;

import java.util.List;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Reservation;

public interface ReservationService {

	
	Reservation save (Reservation reservation) throws ServiceException;
	Reservation update (Reservation reservation) throws ServiceException;
	void remove (Reservation reservation) throws ServiceException;
	List<Reservation> findAll() throws ServiceException;
	Reservation findById (Integer id) throws ServiceException;
}
