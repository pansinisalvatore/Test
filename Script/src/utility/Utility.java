package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import eccezione.CharacterException;
import eccezione.EmptyException;

public class Utility {

	public static String vetToString(String[] string) {
		String s = "";
		for (int i = 0; i < string.length; i++) {
			s = s + " " + string[i];
		}
		return s;
	}
	
	public static boolean formatData(String data) {

		if (data.length() == 10 && data.charAt(2) == '/' && data.charAt(5) == '/' )
			return true;
		else  return false;
	}
	
	public static boolean controlGiorno(String data) {
		
		String[] s = data.split("/");
		int giorno = Integer.parseInt(s[0]);
		
		if(giorno > 0 && giorno < 32) return true;
		else return false;
	}
	
	public static boolean controlMese(String data) {
		
		String[] s = data.split("/");
		int mese = Integer.parseInt(s[1]);
		
		if(mese > 0 && mese < 13) return true;
		else return false;
	}
	
	public static boolean controlAnno(String data) {
		
		String[] s = data.split("/");
		int anno = Integer.parseInt(s[2]);
		
		if(anno > 1980) return true;
		else return false;
	}
	
	public static boolean confrontaDate(String dataMinore, String dataMaggiore) {
		
		String[] sMin = dataMinore.split("/");
		int giornoMin = Integer.parseInt(sMin[0]);
		int meseMin = Integer.parseInt(sMin[1]);
		int annoMin = Integer.parseInt(sMin[2]);
		
		String[] sMax = dataMaggiore.split("/");
		int giornoMax = Integer.parseInt(sMax[0]);
		int meseMax = Integer.parseInt(sMax[1]);
		int annoMax = Integer.parseInt(sMax[2]);
		
		if (annoMin < annoMax) {
			return true;
		}else if (annoMin == annoMax) {
			if(meseMin < meseMax) return true;
			else if (meseMin == meseMax) {
				if(giornoMin <= giornoMax)
					return true;
				else return false;
			} else return false;
		}else return false;
		
	}
	
	public static boolean positivo(String numero) {
		boolean value = false;
		try {
		int num = Integer.parseInt(numero);
		if (num >= 0) value = true;
		} catch (NumberFormatException e) {
			value = false;
		}
		return value;
	}
	
	public static boolean doublePositivo(String numero) {
		String[] s = numero.split(",");
		boolean value = false;
		try {
		String aux = (s[0] + '.' + s[1]).trim();
		double num = Double.parseDouble(aux);
		if (num >= 0) value = true;
		} catch( ArrayIndexOutOfBoundsException e) {
			value = positivo(s[0]);
		}catch(NumberFormatException e) {
			value = false;
		}
		
		return value;
	}
	
	public static void campoVuoto(String string) throws EmptyException {
		String[] split = string.split(";");
		for (int i = 0; i < split.length; i++) {
			if (split[i].equals("") || split[i].equals(" ")) 
				throw new EmptyException(string);
		}
	}
	
	public static boolean controlFormatDateDirectory(String stringa) {
		
		if (stringa.length() != 6) return false;
		int giorno = (Character.getNumericValue(stringa.charAt(0)) *10)
				+ Character.getNumericValue(stringa.charAt(1));
		int mese = (Character.getNumericValue(stringa.charAt(2)) *10)
				+ Character.getNumericValue(stringa.charAt(3));
		int anno = (Character.getNumericValue(stringa.charAt(4)) *10)
				+ Character.getNumericValue(stringa.charAt(5));
		
		if (giorno < 32 && giorno > 0) {
			if(mese < 12 && mese > 0) {
				if(anno > 10) return true;
				else return false;
			}else return false;
		}else return false;
	}

	public static boolean controlFormatHoursDirectory(String stringa) {
		
		if (stringa.length() != 4) return false;
		int ora = (Character.getNumericValue(stringa.charAt(0)) *10) + Character.getNumericValue(stringa.charAt(1));
		int minuti =(Character.getNumericValue(stringa.charAt(2)) *10) + Character.getNumericValue(stringa.charAt(3));
		
		if (ora > 0 && ora < 24) {
			if(minuti > 0 && minuti < 59) return true;
			else return false;
		} else return false;
		
	}
	
	public static boolean stringIntoFile(String string) {
		String nomeFile = "C:/Users/rino9/OneDrive/Dati/Definitivo/CorrectData.csv";
		Scanner scanner;
		
		try {
		 	scanner = new Scanner (new File(nomeFile));
		 	while (scanner.hasNextLine()) {
		 		String stringaFile = scanner.nextLine();
		 		if(string.equals(stringaFile)) return true;
		 	}
		 		scanner.close();
	}catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		return false;
	}
	return false;
}
	
	
	public static void createFile(String nomeFile) {
		PrintWriter output;
		String intestazione = "IdOrdine;IdCorriere;DataOrdine;GiornoOrdine;MeseOrdine;AnnoOrdine;FestivoOrdine;"
				+"DataConsegna;GiornoConsegna;MeseConsegna;AnnoConsegna;"
				+ "CodStatoFattura;CodProvinciaFattura;PosizioneGeografica;ComuneFatturazione;TotaleImponibileFattura;"
				+ "TotaleConIva;IdCliente;Sesso;Quantita;IdMagazzino;PrezzoVendita;PrezzoPieno;"
				+ "PrezzoScontato;Sconto;Outlet;IdTaglia2;NomeDes;LinguaCollezione;LinguaColore;"
				+ "NomeSes;PagamentoOrdine;IdGruppoTaglie;NomeCat;NomeMac";
		try {
			File file = new File(nomeFile);
			if (!file.exists()) {
				//file.createNewFile();
				
				output = new PrintWriter (new FileOutputStream(nomeFile));
				output.println(intestazione);
				output.close();
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	public static void deleteFileErrati() {
		String nome = "C:/Users/rino9/OneDrive/Dati/File Errati";
		File directory = new File(nome);
		String[] list = directory.list();
		
		for (int i = 0; i < list.length; ++i) {
			
			String nomeFile = list[i];
			File f= new File(nome +"/"+nomeFile);
			f.delete();
		}
	}
	
	public static void isNumeric(String num, String intera) throws CharacterException{
		  try{
		    Integer.parseInt(num);
		  }catch(Exception e){
		    try{
		      Double.parseDouble(num);
		    }catch(Exception z){
		      throw new CharacterException(intera);
		    }
		  }
		}


}
