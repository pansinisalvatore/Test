package eccezione;

public class CharacterException extends GeneralException {

	public CharacterException(String string) {
		super("Il campo non è numerico " + string);
	}
}
