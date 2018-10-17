import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Definitivo extends Dati {

	
	private static final String INTESTAZIONE = "IdOrdine;IdCorriere;DataOrdine;DataConsegna;"
			+ "CodStatoFattura;CodProvinciaFattura;Location;ComuneFatturazione;TotaleImponibileFattura;"
			+ "TotaleConIva;IdCliente;Sesso;Quantita;IdMagazzino;PrezzoVendita;PrezzoPieno;"
			+ "PrezzoScontato;Sconto;Outlet;IdTaglia2;NomeDes;LinguaCollezione;LinguaColore;"
			+ "NomeSes;PagamentoOrdine;IdGruppoTaglie;NomeCat;NomeMac";
	
	private String nomeGiorno;
	private String nomeMese;
	private String anno;
	private String location;
	
	public void setLocation() {
		 String nomeFile = "elenco comuni.csv";
		 Scanner scanner;
		 try {
			 	scanner = new Scanner (new File(nomeFile));
			 	scanner.nextLine();
			 	while(scanner.hasNextLine()) {
			 		String stringa = scanner.nextLine();
			 		String[] split = stringa.split(";");
			 		String posizione = split[1];
			 		String provincia = split[2].toUpperCase();
			 		if (provincia.equals(getCodProvinciaFattura()))
			 			location = posizione;
			 	}
			 
		 }catch (FileNotFoundException e) {
			 System.out.println(e.getMessage());
		 }
	}
	
	public String getLocation() {
		return location;
	}
	
	
	public String toString() {
		return getIdOrdine() + ";" + getIdCorriere() + ";" + getDataOrdine() + ";" +
				getDataConsegna() + ";" + getCodStatoFattura() + ";" +
				getCodProvinciaFattura() + ";" + getLocation() + ";" + getComuneFatturazione() + ";" +
				getTotaleImponibileFattura() + ";" + getTotaleConIva() +";" +
				getIdCliente() + ";" +  getSesso() + ";" + getQuantita()  + ";" +
				getIdMagazzino()  + ";" + getPrezzoVendita()  + ";" + getPrezzoPieno()  + ";" +
				getPrezzoScontato()  + ";" + getSconto()  + ";" + getOutlet()  + ";" +
				getIdTaglia2()  + ";" + getNomeDes()  + ";" + getLinguaCollezione()  + ";" +
					 getLinguaColore()  + ";" + getNomeSes()  + ";" + getPagamentoOrdine()  + ";" +
				 getIdGruppoTaglie()  + ";" + getNomeCat()  + ";" + getNomeMac();
		 
	}
	
	
	
	
}
