package eccezione;

public class EmptyException extends GeneralException {

	public EmptyException(String riga) {
		super("Campo vuoto nella riga " + riga);
	}
}
