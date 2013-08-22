package fr.treeptik.locationvoiture.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DAOException (String message, Throwable exception){
		super(message, exception);
	}

}
