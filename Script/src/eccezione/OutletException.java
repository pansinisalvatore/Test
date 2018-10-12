package eccezione;

public class OutletException extends GeneralException {

	public OutletException(String riga) {
		super("Errore nella riga " + riga + ". Range non valido");
	}
}
