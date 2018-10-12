package eccezione;

public class StatoException extends GeneralException {

	public StatoException(String riga) {
		super("Errore nella riga " + riga + ". Range non valido");
	}
}
