import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
			while (scanner.hasNextLine()) {
				try {
				String stringa;
				stringa = scanner.nextLine();

				Utility.campoVuoto(stringa);
				Dati dati = new Dati(stringa.split(";"));
				dati.controllaNumeroColonne(stringa);
				datiCorretti.add(dati);
				dati = null;
				}catch (GeneralException e) {
					System.out.println(e.getMessage());
					fileError(e.getMessage(),"C:/Users/rino9/OneDrive/Dati/File Errati/" + split[0]+"_" +split[1] + ".txt");
					erroreTrovato = true;
				}
				
			}
			scanner.close();
			if(!erroreTrovato)
			addDefinitivo(nomeFile);
			}
		
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (GeneralException e) {
			System.out.println(e.getMessage());
			
			System.exit(0);
		}
		
	}
	
	public void addDefinitivo(String nomeFile) {
		
		
		PrintWriter output= null;
		String nome = "C:/Users/rino9/OneDrive/Dati/Definitivo/def.csv";
		for (int i = 0; i < datiCorretti.size(); i++) {
			
		Definitivo definitivo = new Definitivo(datiCorretti.get(i).toString());
		definitivo.setLocation();
		try {
			definitivo.estrapolaData();
		output = new PrintWriter (new FileOutputStream(nome, true));
		String riga = definitivo.toString();
		System.out.println(riga);
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
		
		System.out.println("L'operazione di inserimento e' andata a buon fine!");
		
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

	
}
