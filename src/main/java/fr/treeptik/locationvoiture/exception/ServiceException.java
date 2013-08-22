package fr.treeptik.locationvoiture.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ServiceException (String message, Throwable exception){
		super(message, exception);
	}

}
