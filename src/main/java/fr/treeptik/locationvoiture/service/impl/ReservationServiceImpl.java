package fr.treeptik.locationvoiture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDAO reservationDAO;

	@Override
	@Transactional
	public Reservation save(Reservation reservation) throws ServiceException {
		try {
			reservationDAO.save(reservation);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return reservation;
	}

	@Override
	@Transactional
	public Reservation update(Reservation reservation) throws ServiceException {
		try {
			reservation = reservationDAO.update(reservation);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
		return reservation;
	}

	@Override
	@Transactional
	public void remove(Reservation reservation) throws ServiceException {
		try {
			reservationDAO.remove(reservation);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
		
	}

	@Override
	public List<Reservation> findAll() throws ServiceException {

		List<Reservation> reservations = new ArrayList<>();
		
		try {
			reservations = reservationDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return reservations;
	}

	@Override
	public Reservation findById(Integer id) throws ServiceException {
		
		Reservation reservation = null;
		
		try {
			reservation = reservationDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return reservation;
	}

}
