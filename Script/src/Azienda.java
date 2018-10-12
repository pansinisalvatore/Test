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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import eccezione.DateFormatException;
import eccezione.GeneralException;
import eccezione.IntestazioneException;
import utility.Utility;
public class Azienda {

	
	private static int conteggio = 0;
	
	
	
	public void controllaDati(){ 
		
		ArrayList <String> fileDaControllare;
		Scanner scanner;
		
		int conta = 0;
		try {
			fileDaControllare = controlFileName();
			if (fileDaControllare == null) throw new FileNotFoundException("Nessun file con il giusto formato");
			
			for (int i = 0; i < fileDaControllare.size(); i++) {
				String nomeFile = "C:/Users/rino9/OneDrive/Dati/" + fileDaControllare.get(i);
				System.out.println("nomeFile:" + nomeFile);
			
			scanner = new Scanner (new File(nomeFile));
			String aux =scanner.nextLine(); 
			System.out.println(aux);
			Dati.controllaIntestazione(aux);
			while (scanner.hasNextLine()) {
				String[] stringa;
				String s;
				s = scanner.nextLine();
				System.out.println(s);
				stringa = s.split(";");
				Utility.campoVuoto(stringa);
				Dati dati = new Dati();
				dati.set(stringa);
				dati.controllaNumeroColonne(stringa);
				dati.controllaSesso(Utility.vetToString(stringa));
				dati.controllaData(stringa);
				dati.controllaOutlet(stringa);
				
				}
			scanner.close();
			}
		
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (GeneralException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void addDefinitivo() {
		
		
		PrintWriter output= null;
		String s = "82;1;21/09/2010;28/09/2010;LU;Lu;P�tange;128,33;154;1478;3;-1;2851;154;154;77;50;1;3;AERONAUTICA MILITARE;Autunno - Inverno 2011;Blu;Uomo;PayPal;2;Maglieria;Abbigliamento";
		String nome = "C:/Users/rino9/OneDrive/Dati/Definitivo/def.csv";
	
		try {
		output = new PrintWriter (new FileOutputStream(nome, true));
		
			output.write(s + "/n");
		output.close();
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println("Errore nella scrittura del file");
		}
	}
	
	private void createFile(String nomeFile) {
		try {
			File file = new File(nomeFile);
			if (!file.exists()) {
				file.createNewFile();
				System.out.println(file.getName());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public ArrayList<String> controlFileName() {
		int trovati = 0;
		DateFormat date = new SimpleDateFormat("dd/MM/yy");
		ArrayList <String> file = new ArrayList<String>();
		String nome = "C:/Users/rino9/OneDrive/Dati";
		File directory = new File(nome);
		String[] list = directory.list();
		System.out.println("list.lenght: " + list.length);
		for (int i = 0; i < list.length; ++i) {
			String data, ora;
			System.out.println("File presenti: " + list[i]);
			String nomeFile = list[i];
			String[] split = nomeFile.split("_");
			if (split.length == 2) {
				data = split[0];
				ora = split[1].substring(0, 4);
				System.out.println("lungh " + split.length);
				System.out.println("split[0]: " + data);
				System.out.println("split[1]: " + ora);
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
	

	
}