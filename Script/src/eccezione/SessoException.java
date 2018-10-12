package eccezione;

public class SessoException extends GeneralException {

	public SessoException (String riga) {
		super("Il sesso inserito nella riga " + riga +" non e' valido");
	}
	
}
