package fr.treeptik.locationvoiture.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.locationvoiture.model.Reservation;

public class ReservationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.getClass().equals(Reservation.class);
	}

	@Override
	public void validate(Object reservation, Errors errors) {
		
		Reservation s = (Reservation) reservation;
		
//		if()
		
	}

}
