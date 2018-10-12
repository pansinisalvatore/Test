package eccezione;

public class NegativeException extends GeneralException {
	
	public NegativeException(String messaggio) {
		super (messaggio + " non deve essere negativo.");
	}

}
