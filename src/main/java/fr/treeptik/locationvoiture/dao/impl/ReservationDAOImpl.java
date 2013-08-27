package fr.treeptik.locationvoiture.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Reservation;

@Repository
public class ReservationDAOImpl implements ReservationDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Reservation save(Reservation reservation) throws DAOException {
		entityManager.persist(reservation);
		return reservation;
	}

	@Override
	public Reservation update(Reservation reservation) throws DAOException {
		Reservation r = null;
		try {
			r = entityManager.merge(reservation);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
		
		return r;
	}

	@Override
	public void remove(Reservation reservation) throws DAOException {
try {
			
			Query query = entityManager.createQuery("Delete from Reservation r where r.id= :id");
			query.setParameter("id", reservation.getId());
			query.executeUpdate();
			
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
		
	}

	@Override
	public List<Reservation> findAll() throws DAOException {

		List<Reservation> reservations = null;
	
		
		try {
			
			TypedQuery<Reservation> query = entityManager.createQuery("Select r from Reservation r", Reservation.class);
			reservations = query.getResultList();
			
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
		return reservations;
	}

	@Override
	public Reservation findById(Integer id) throws DAOException {


		Reservation r = null;
		
		try {
			
			r = entityManager.find(Reservation.class, id);
			
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
		return r;
	}

}
