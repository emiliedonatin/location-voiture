package fr.treeptik.locationvoiture.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.locationvoiture.model.Client;

@Component
public class ClientValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.getClass().equals(Client.class);
	}

	@Override
	public void validate(Object client, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	

}
