package eccezione;

public class NumeroColonneException extends GeneralException {

	public NumeroColonneException(int lunghezzaColonne, String riga) {
		super(controllaColonna(lunghezzaColonne,riga));
		
	}
	
	private static String controllaColonna(int lunghezzaColonne, String riga) {
		
		if ((27 - lunghezzaColonne) == 1)
			return "E' presente una colonna in meno";
		else if ((27 - lunghezzaColonne) > 1)
			return "Ci sono " + (27 - lunghezzaColonne) + " " + "in meno.";
		else return (lunghezzaColonne - 27 ) + " " + "in piu'";
	}
	
}
