
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Definitivo extends Dati {

	public static final String INTESTAZIONE = "IdOrdine;IdCorriere;DataOrdine;GiornoOrdine;MeseOrdine;AnnoOrdine;FestivoOrdine"
			+"DataConsegna;GiornoConsegna;MeseConsegna;AnnoConsegna;"
			+ "CodStatoFattura;CodProvinciaFattura;PosizioneGeografica;ComuneFatturazione;TotaleImponibileFattura;"
			+ "TotaleConIva;IdCliente;Sesso;Quantita;IdMagazzino;PrezzoVendita;PrezzoPieno;"
			+ "PrezzoScontato;Sconto;Outlet;IdTaglia2;NomeDes;LinguaCollezione;LinguaColore;"
			+ "NomeSes;PagamentoOrdine;IdGruppoTaglie;NomeCat;NomeMac";
	private String location;
	private String nomeGiornoOrdine;
	private int numeroGiornoSettOrdine;
	private String nomeGiornoConsegna;
	private String nomeMeseOrdine;
	private String nomeMeseConsegna;
	private String annoOrdine;
	private String annoConsegna;
	private String isFestivoOrdine;

	public Definitivo(String set) {
		super(set);

		
	}
	public void setLocation() {
		ArrayList <Provincia> provincia = getProvincia();
		boolean trovato = false;
		for (int i = 0; i < provincia.size(); i++) {
			if (getCodProvinciaFattura().equals(provincia.get(i).getSigla())) {
				location = provincia.get(i).getPosizione();
				trovato = true;
				break;
			}
				
		}
		
		if(!trovato) location = "Estero";
	}
	
	private void setLocation(String posizione) {
		this.location = posizione;
		
	}
	public String getLocation() {
		return location;
	}
	
	

	public String toString() {
		return getIdOrdine() + ";" + getIdCorriere() + ";" + getDataOrdine() + ";" + getNomeGiornoOrdine()+";" +
				getNomeMeseOrdine() + ";" + getAnnoOrdine() +";" + getIsFestivoOrdine() + ";" +getDataConsegna() + ";" +
				getNomeGiornoConsegna()+";" + getNomeMeseConsegna() + ";" + getAnnoConsegna() +";" 
				+ getCodStatoFattura() + ";" +
				getCodProvinciaFattura() + ";" + getLocation() + ";" + getComuneFatturazione() + ";" +
				getTotaleImponibileFattura() + ";" + getTotaleConIva() +";" +
				getIdCliente() + ";" +  getSesso() + ";" + getQuantita()  + ";" +
				getIdMagazzino()  + ";" + getPrezzoVendita()  + ";" + getPrezzoPieno()  + ";" +
				getPrezzoScontato()  + ";" + getSconto()  + ";" + getOutlet()  + ";" +
				getIdTaglia2()  + ";" + getNomeDes()  + ";" + getLinguaCollezione()  + ";" +
					 getLinguaColore()  + ";" + getNomeSes()  + ";" + getPagamentoOrdine()  + ";" +
				 getIdGruppoTaglie()  + ";" + getNomeCat()  + ";" + getNomeMac();
		 
	}


	
	
	
	public void estrapolaData() throws ParseException  {
		
		 setNomeGiornoOrdine(new SimpleDateFormat("EEEE").format(new SimpleDateFormat("dd/MM/yyyy").parse(getDataOrdine())));
		 setNomeGiornoConsegna(new SimpleDateFormat("EEEE").format(new SimpleDateFormat("dd/MM/yyyy").parse(getDataConsegna())));
	     Calendar c= Calendar.getInstance();
	     c.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(getDataOrdine()));
	     numeroGiornoSettOrdine= c.get(Calendar.DAY_OF_WEEK);
	     setNomeMeseOrdine(new SimpleDateFormat("MMMM").format(c.getTime()));
	     setAnnoOrdine(((Integer)c.get(Calendar.YEAR)).toString());
	     setIsFestivoOrdine(isFestivo());
	     c.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(getDataConsegna()));
	     setNomeMeseConsegna(new SimpleDateFormat("MMMM").format(c.getTime()));
	     setAnnoConsegna(((Integer)c.get(Calendar.YEAR)).toString());
	     
	}
	
	
		public String isFestivo() throws ParseException {
			String festivo="NO";
			String date2 = getDataOrdine().substring(0,4);
			switch (date2) {
			case ("01/01"):{
				festivo="YES";
				break;
			}
			case ("06/01"):
				festivo="YES";
				break;
			case ("25/04"):
				festivo="YES";
				break;
			case ("01/05"):
				festivo="YES";
				break;
			case ("02/06"):
				festivo="YES";
				break;
			case ("15/08"):
				festivo="YES";
				break;
			case ("01/11"):
			    festivo="YES";
				break;
			case ("08/12"):
				festivo="YES";
				break;
			case ("25/12"):
				festivo="YES";
				break;
			case ("26/12"):
				festivo="YES";
				break;
				
			}
	  
		   if (numeroGiornoSettOrdine==1 || numeroGiornoSettOrdine==7) {
			   festivo="YES";
			   
		   }
		   
		    Calendar calendar = new GregorianCalendar();
	 	    calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(getDataOrdine()));
	 				
	 		int year = calendar.get(Calendar.YEAR);
	 		int dateYMD = year * 10000 + 
	 					calendar.get(Calendar.MONTH) * 100 +  
	 					calendar.get(Calendar.DAY_OF_MONTH);
	 		Date easter = find(year);
	 		calendar.setTime(easter);
	 		int easterYMD = year * 10000 + 
	 					calendar.get(Calendar.MONTH) * 100 +  
	 					calendar.get(Calendar.DAY_OF_MONTH);
	 		if (easterYMD == dateYMD ) {
	 			festivo= "YES";
	 		}        
			
			return festivo;
	}
	

	 	 	
	 	 	
 	 	public final static Date find(int year) {
 	
 	 		int a = year % 19;
 	 		int b = year % 4;
 	 		int c = year % 7;
 	 		
 	 		int m = 0;
 	 		int n = 0;
 	 		
 	 		if ( (year >= 1583) && (year <= 1699) ) { m = 22; n = 2; }
 	 		if ( (year >= 1700) && (year <= 1799) ) { m = 23; n = 3; }
 	 		if ( (year >= 1800) && (year <= 1899) ) { m = 23; n = 4; }
 	 		if ( (year >= 1900) && (year <= 2099) ) { m = 24; n = 5; }
 	 		if ( (year >= 2100) && (year <= 2199) ) { m = 24; n = 6; }
 	 		if ( (year >= 2200) && (year <= 2299) ) { m = 25; n = 0; }
 	 		if ( (year >= 2300) && (year <= 2399) ) { m = 26; n = 1; }
 	 		if ( (year >= 2400) && (year <= 2499) ) { m = 25; n = 1; }
 	 		
 	 		int d = (19 * a + m) % 30;
 	 		int e = (2 * b + 4 * c + 6 * d + n) % 7;   
 	 
 	 		Calendar calendar = new GregorianCalendar();
 	 		calendar.set(Calendar.YEAR , year);
 	 		
 	 		if ( d+e < 10 ) {
 	 			calendar.set(Calendar.MONTH , Calendar.MARCH);
 	 			calendar.set(Calendar.DAY_OF_MONTH, d + e + 22);
 	 		} else {
 	 			calendar.set(Calendar.MONTH , Calendar.APRIL);
 	 			int day = d+e-9;
 	 			if ( 26 == day ) {day = 19;}
 	 			if ( ( 25 == day ) && ( 28 == d) && ( e == 6 ) && ( a > 10 ) ) { day = 18; }
 	 			calendar.set(Calendar.DAY_OF_MONTH, day);
 	 		}
 	 		
 	 		return calendar.getTime();
 	 	}


		public String getNomeGiornoConsegna() {
			return nomeGiornoConsegna;
		}


		public void setNomeGiornoConsegna(String nomeGiornoConsegna) {
			this.nomeGiornoConsegna = nomeGiornoConsegna;
		}


		public String getNomeGiornoOrdine() {
			return nomeGiornoOrdine;
		}


		public void setNomeGiornoOrdine(String nomeGiornoOrdine) {
			this.nomeGiornoOrdine = nomeGiornoOrdine;
		}


		public String getNomeMeseOrdine() {
			return nomeMeseOrdine;
		}


		public void setNomeMeseOrdine(String nomeMeseOrdine) {
			this.nomeMeseOrdine = nomeMeseOrdine;
		}


		public String getNomeMeseConsegna() {
			return nomeMeseConsegna;
		}


		public void setNomeMeseConsegna(String nomeMeseConsegna) {
			this.nomeMeseConsegna = nomeMeseConsegna;
		}


		public String getAnnoOrdine() {
			return annoOrdine;
		}


		public void setAnnoOrdine(String annoOrdine) {
			this.annoOrdine = annoOrdine;
		}


		public String getAnnoConsegna() {
			return annoConsegna;
		}


		public void setAnnoConsegna(String annoConsegna) {
			this.annoConsegna = annoConsegna;
		}


		public String getIsFestivoOrdine() {
			return isFestivoOrdine;
		}


		public void setIsFestivoOrdine(String isFestivoOrdine) {
			this.isFestivoOrdine = isFestivoOrdine;
		}
 	 	

 	 	
 	 }
	
	

