import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;



import eccezione.DateFormatException;
import eccezione.GeneralException;
import eccezione.IntestazioneException;
import utility.Utility;
public class Azienda {

	
	private static int conteggio = 0;
	private ArrayList <Dati> datiCorretti;
	
	public Azienda() {
		datiCorretti = new ArrayList <Dati>();
	}
	
	public void controllaDati(){ 
		
		ArrayList <String> fileDaControllare;
		Scanner scanner;
		boolean erroreTrovato = false;
		boolean presente = false;
		String stringa = "";
	
		try {
			fileDaControllare = controlFileName();
			if (fileDaControllare == null) throw new FileNotFoundException("Nessun file con il giusto formato");
			
			for (int i = 0; i < fileDaControllare.size(); i++) {
				String nomeFile = "C:/Users/rino9/OneDrive/Dati/" + fileDaControllare.get(i);
				System.out.println("nome file: " + fileDaControllare.get(i));
				String file = fileDaControllare.get(i);
				String[] split = file.split("_");
				String s = split[1].substring(0, 3);
				
			
			scanner = new Scanner (new File(nomeFile));
			String aux =scanner.nextLine(); 
			Dati.controllaIntestazione(aux);
			System.out.print("Caricamento in corso...");
			int conta = 0;
			while (scanner.hasNextLine()) {
				
				try { 
				
				stringa = scanner.nextLine();
				for (int j = 0; j < datiCorretti.size(); j++) {
					if(datiCorretti.get(j).toString().equals(stringa)) {
						presente = true;
						break;
					}
				}
				//
				
				if (!presente) {
				Utility.campoVuoto(stringa);
				Dati dati = new Dati(stringa.split(";"));
				dati.controllaNumeroColonne(stringa);
			
				datiCorretti.add(dati);
				conta++;
				dati = null;
				}
				}catch (GeneralException e) {
					//System.out.println(e.getMessage());
					fileError(e.getMessage(),"C:/Users/rino9/OneDrive/Dati/File Errati/" + split[0]+"_" +split[1] + ".txt");
					erroreTrovato = true;
				}catch (java.lang.ArrayIndexOutOfBoundsException e) {
					//System.out.println("L'ultimo campo è vuoto alla riga " + stringa);
					fileError("Array Index out of bound: " + stringa,"C:/Users/rino9/OneDrive/Dati/File Errati/" + split[0]+"_" +split[1] + ".txt");
					erroreTrovato=true;
				}
				
			}
			scanner.close();
			addDefinitivo(nomeFile);
			if(!erroreTrovato) {
				System.out.println("L'operazione di inserimento e' andata a buon fine!");
			}
			else System.out.println("Controllo dei file finito. Visualizza la cartella File Errati per conoscere gli errori");
			}
		
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (GeneralException e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void addDefinitivo(String nomeFile) {
		
		
		PrintWriter output= null;
		String nome = "C:/Users/rino9/OneDrive/Dati/Definitivo/CorrectData.csv";
		Utility.createFile(nome);
		for (int i = 0; i < datiCorretti.size(); i++) {
			
		Definitivo definitivo = new Definitivo(datiCorretti.get(i).toString());
		definitivo.setLocation();
		try {
			definitivo.estrapolaData();
		output = new PrintWriter (new FileOutputStream(nome, true));
		String riga = definitivo.toString();
		
		if(!Utility.stringIntoFile(riga))
			output.println(riga);
		output.close();
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println("Errore nella scrittura del file");
		} catch (ParseException e) {
		   System.out.println(e.getMessage());
		}
		
		}
		
		
		backup(nome);
		
		File file = new File(nomeFile);
		file.delete();
		
	}
	
	
	
	public ArrayList<String> controlFileName() {
		int trovati = 0;
		DateFormat date = new SimpleDateFormat("dd/MM/yy");
		ArrayList <String> file = new ArrayList<String>();
		String nome = "C:/Users/rino9/OneDrive/Dati";
		File directory = new File(nome);
		String[] list = directory.list();
		
		for (int i = 0; i < list.length; ++i) {
			String data, ora;
			
			String nomeFile = list[i];
			String[] split = nomeFile.split("_");
			if (split.length == 2) {
				data = split[0];
				ora = split[1].substring(0, 4);
				if(Utility.controlFormatDateDirectory(data) && 
						Utility.controlFormatHoursDirectory(ora)) {
					file.add(nomeFile);
					trovati++;
				}
				
			}
		}
		
		if (trovati > 0) return file;
		else return null;
		
	}
	
	public void fileError(String messaggioErrore, String nomeFile) {
		
		PrintWriter output;
		
		try {
			File file = new File(nomeFile);
			output = new PrintWriter (new FileOutputStream(nomeFile,true));
			
				output.println(messaggioErrore);
				output.close();
			
			//file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void backup(String nomeSource) {
		
		String nomeCopy = "C:/Users/rino9/OneDrive/backup definitivo/backupCorrectData.csv";
		File copy = new File (nomeCopy);
		File source = new File (nomeSource);
		copy.delete();
		PrintWriter scrittura = null;
		Scanner scanner = null;
		try {
			scrittura = new PrintWriter(new FileOutputStream(copy));
			scanner = new Scanner (source);
			while (scanner.hasNextLine()) {
				String riga = scanner.nextLine();
				scrittura.println(riga);
			}
			scrittura.close();
			scanner.close();
		}catch (FileNotFoundException e) {
			System.out.println("Impossibile effettuare il backup");
		}
		
	}

	
}
