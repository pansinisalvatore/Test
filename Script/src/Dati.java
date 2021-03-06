import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import eccezione.CharacterException;
import eccezione.DataException;
import eccezione.GeneralException;
import eccezione.NegativeException;
import eccezione.OutletException;
import eccezione.SessoException;
import eccezione.StatoException;
import utility.Utility;
public class Dati {
	private static final String INTESTAZIONE = "IdOrdine;IdCorriere;DataOrdine;DataConsegna;"
			+ "CodStatoFattura;CodProvinciaFattura;ComuneFatturazione;TotaleImponibileFattura;"
			+ "TotaleConIva;IdCliente;Sesso;Quantita;IdMagazzino;PrezzoVendita;PrezzoPieno;"
			+ "PrezzoScontato;Sconto;Outlet;IdTaglia2;NomeDes;LinguaCollezione;LinguaColore;"
			+ "NomeSes;PagamentoOrdine;IdGruppoTaglie;NomeCat;NomeMac";
	
	
	private String idOrdine;
	private String idCorriere;
	private String dataOrdine;
	private String dataConsegna;
	private String codStatoFattura;
	private String codProvinciaFattura;
	private String comuneFatturazione;
	private String totaleImponibileFattura;
	private String totaleConIva;
	private String idCliente;
	private String sesso;
	private String quantita;
	private String idMagazzino;
	private String prezzoVendita;
	private String prezzoPieno;
	private String prezzoScontato;
	private String sconto;
	private String outlet;
	private String idTaglia2;
	private String nomeDes;
	private String linguaCollezione;
	private String linguaColore;
	private String nomeSes;
	private String pagamentoOrdine;
	private String idGruppoTaglie;
	private String nomeCat;
	private String nomeMac;
	private ArrayList <Provincia> provincia;
	
	/**
	 * fa i controlli
	 * @param split
	 */
	public Dati(String[] split) throws GeneralException {
		setProvincia();	
		set(split);
			
	}
	
	public Dati(String string) {
		setProvincia();	
		set(string);
		
		
	}
	public ArrayList <Provincia> getProvincia(){
		return this.provincia;
	}
	public void set(String string) {
		String[] stringa = string.split(";");
			idOrdine = stringa[0];
			idCorriere = stringa [1];
			dataOrdine = stringa [2].trim();
			dataConsegna = stringa [3].trim();
			codStatoFattura = stringa [4];
			codProvinciaFattura = stringa [5];
			comuneFatturazione = stringa [6];
			totaleImponibileFattura = stringa [7];
			totaleConIva = stringa[8];
			idCliente = stringa[9];	
			sesso = stringa [10];
			quantita = stringa[11];
			idMagazzino = stringa [12];
			prezzoVendita = stringa [13];
			prezzoPieno = stringa [14];
			prezzoScontato = stringa [15];
			sconto = stringa [16];
			outlet = stringa [17];
			idTaglia2 = stringa [18];
			nomeDes = stringa [19];
			linguaCollezione = stringa [20]; 
			linguaColore = stringa [21];
			nomeSes = stringa [22];
			pagamentoOrdine = stringa [23];
			idGruppoTaglie = stringa [24];
			nomeCat = stringa [25];
			nomeMac = stringa [26];
			
	}
	public String getIdOrdine() {
		return idOrdine;
	}
	public void setIdOrdine(String idOrdine) {
		this.idOrdine = idOrdine;
	}
	public String getIdCorriere() {
		return idCorriere;
	}
	public void setIdCorriere(String idCorriere) {
		this.idCorriere = idCorriere;
	}
	public String getDataOrdine() {
		return dataOrdine;
	}
	public void setDataOrdine(String dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	public String getDataConsegna() {
		return dataConsegna;
	}
	public void setDataConsegna(String dataConsegna) {
		this.dataConsegna = dataConsegna;
	}
	public String getCodStatoFattura() {
		return codStatoFattura;
	}
	public void setCodStatoFattura(String codStatoFattura) {
		this.codStatoFattura = codStatoFattura;
	}
	public String getCodProvinciaFattura() {
		return codProvinciaFattura;
	}
	public void setCodProvinciaFattura(String codProvinciaFattura) {
		this.codProvinciaFattura = codProvinciaFattura;
	}
	public String getComuneFatturazione() {
		return comuneFatturazione;
	}
	public void setComuneFatturazione(String comuneFatturazione) {
		this.comuneFatturazione = comuneFatturazione;
	}
	public String getTotaleImponibileFattura() {
		return totaleImponibileFattura;
	}
	public void setTotaleImponibileFattura(String totaleImponibileFattura) {
		this.totaleImponibileFattura = totaleImponibileFattura;
	}
	public String getTotaleConIva() {
		return totaleConIva;
	}
	public void setTotaleConIva(String totaleConIva) {
		this.totaleConIva = totaleConIva;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getQuantita() {
		return quantita;
	}
	public void setQuantita(String string,String intera) throws CharacterException {
		
		int quantitaPos;
		try {
			if ((Integer.parseInt(string))<0) {
				quantitaPos=Integer.parseInt(string)*(-1);
				quantita = (String.valueOf(quantitaPos));
			} else quantita = string;
		}catch (NumberFormatException e) {
			throw new CharacterException(intera);
		}
		
	}
	public String getIdMagazzino() {
		return idMagazzino;
	}
	public void setIdMagazzino(String idMagazzino) {
		this.idMagazzino = idMagazzino;
	}
	public String getPrezzoVendita() {
		return prezzoVendita;
	}
	public void setPrezzoVendita(String prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}
	public String getPrezzoPieno() {
		return prezzoPieno;
	}
	public void setPrezzoPieno(String prezzoPieno) {
		this.prezzoPieno = prezzoPieno;
	}
	public String getPrezzoScontato() {
		return prezzoScontato;
	}
	public void setPrezzoScontato(String prezzoScontato) {
		this.prezzoScontato = prezzoScontato;
	}
	public String getSconto() {
		return sconto;
	}
	public void setSconto(String sconto) {
		this.sconto = sconto;
	}
	public String getOutlet() {
		return outlet;
	}
	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}
	public String getIdTaglia2() {
		return idTaglia2;
	}
	public void setIdTaglia2(String idTaglia2) {
		this.idTaglia2 = idTaglia2;
	}
	public String getLinguaCollezione() {
		return linguaCollezione;
	}
	public void setLinguaCollezione(String linguaCollezione) {
		this.linguaCollezione = linguaCollezione;
	}
	public String getNomeDes() {
		return nomeDes;
	}
	public void setNomeDes(String nomeDes) {
		this.nomeDes = nomeDes;
	}
	public String getLinguaColore() {
		return linguaColore;
	}
	public void setLinguaColore(String linguaColore) {
		this.linguaColore = linguaColore;
	}
	public String getNomeSes() {
		return nomeSes;
	}
	public void setNomeSes(String nomeSes) {
		this.nomeSes = nomeSes;
	}
	public String getIdGruppoTaglie() {
		return idGruppoTaglie;
	}
	public void setIdGruppoTaglie(String idGruppoTaglie) {
		this.idGruppoTaglie = idGruppoTaglie;
	}
	public String getNomeCat() {
		return nomeCat;
	}
	public void setNomeCat(String nomeCat) {
		this.nomeCat = nomeCat;
	}
	public String getPagamentoOrdine() {
		return pagamentoOrdine;
	}
	public void setPagamentoOrdine(String pagamentoOrdine) {
		this.pagamentoOrdine = pagamentoOrdine;
	}
	public String getNomeMac() {
		return nomeMac;
	}
	public void setNomeMac(String nomeMac) {
		this.nomeMac = nomeMac;
	}
	
	public void set(String[] stringa) throws GeneralException {
		
		if (Utility.positivo(stringa[0]))
		idOrdine = stringa[0];
		else throw new NegativeException("idOrdine nella riga" + Utility.vetToString(stringa));
		if (Utility.positivo(stringa[1]))
		idCorriere = stringa [1];
		else throw new NegativeException("idCorriere nella riga" + Utility.vetToString(stringa));
		dataOrdine = stringa [2].trim();
		dataConsegna = stringa [3].trim();
		controllaData(stringa);
		codStatoFattura = stringa [4].toUpperCase();
		codProvinciaFattura = stringa [5];
		if (codStatoFattura.equals("IT") && controllaProvincia()) {
			codProvinciaFattura = stringa [5].toUpperCase();
		}else {
			codProvinciaFattura = stringa [5].toLowerCase();
		}
		
		//controllaStato(stringa);
		comuneFatturazione = stringa [6];
		if (Utility.doublePositivo(stringa[7]))
		totaleImponibileFattura = stringa [7];
		else throw new NegativeException("totalemponibileFattura nella riga" + Utility.vetToString(stringa));
		if (Utility.doublePositivo(stringa[8]))
		totaleConIva = stringa[8];
		else throw new NegativeException("totaleConIva nella riga" + Utility.vetToString(stringa));
		if (Utility.positivo(stringa[9]))
		idCliente = stringa[9];
		else throw new NegativeException("idCliente nella riga" + Utility.vetToString(stringa));	
		sesso = stringa [10];
		controllaSesso(Utility.vetToString(stringa));
		setQuantita(stringa[11],Utility.vetToString(stringa));
		if (Utility.positivo(stringa[12]))
		idMagazzino = stringa [12];
		else throw new NegativeException("idMagazzino nella riga" + Utility.vetToString(stringa));
		if (Utility.doublePositivo(stringa[13]))
		prezzoVendita = stringa [13];
		else throw new NegativeException("prezzoVendita nella riga" + Utility.vetToString(stringa));
		if (Utility.doublePositivo(stringa[14]))
		prezzoPieno = stringa [14];
		else throw new NegativeException("prezzoPieno nella riga" + Utility.vetToString(stringa));
		if (Utility.doublePositivo(stringa[15]))
		prezzoScontato = stringa [15];
		else throw new NegativeException("prezzoScontato nella riga" + Utility.vetToString(stringa));
		if (Utility.doublePositivo(stringa[16]))
		sconto = stringa [16];
		else throw new NegativeException("sconto nella riga" + Utility.vetToString(stringa));
		outlet = stringa [17];
		controllaOutlet(stringa);
		if (Utility.positivo(stringa[18]))
		idTaglia2 = stringa [18];
		else throw new NegativeException("idTaglia2 nella riga" + Utility.vetToString(stringa));
		nomeDes = stringa [19];
		linguaCollezione = stringa [20]; 
		linguaColore = stringa [21];
		nomeSes = stringa [22];
		pagamentoOrdine = stringa [23];
		if (Utility.positivo(stringa[24]))
		idGruppoTaglie = stringa [24];
		else throw new NegativeException("idGruppo nella riga" + Utility.vetToString(stringa));
		nomeCat = stringa [25];
		nomeMac = stringa [26];
		
	}
	
	public static void controllaIntestazione(String string) throws eccezione.IntestazioneException{
		if(!INTESTAZIONE.equals(string))
			throw new eccezione.IntestazioneException();
	}
	
	public void controllaNumeroColonne(String string) throws eccezione.NumeroColonneException{
		String[] vet = string.split(";");
		if (vet.length != 27) throw new eccezione.NumeroColonneException(vet.length,Utility.vetToString(vet) );
	}
	
	public void controllaSesso (String riga) throws SessoException{
	
		if (sesso.equals("3")) setSesso("Uomo");
		else if (sesso.equals("4")) setSesso("Donna");
		else throw new SessoException(riga);
			
	}
	/**
	 * Controllo lunghezza di dataOrdine e dataConsegna
	 * Controllo se il giorno � positivo e minore di 31
	 * Controllo se il mese � positivo e minore di 13
	 * Controllo se l'anno � positivo
	 * @param vet
	 * @throws DataException
	 */
	public void controllaData(String[] vet) throws DataException{
		
		if (!Utility.formatData(dataOrdine))
			throw new DataException("formato dataOrdine errato nella riga " + Utility.vetToString(vet));
		
		if (!Utility.formatData(dataConsegna)) 
			throw new DataException("formato dataConsegna errato nella riga " + Utility.vetToString(vet));
		
		if (!Utility.controlGiorno(dataOrdine))
			throw new DataException("Giorno dell' ordine errato nella riga: " + Utility.vetToString(vet));
		
		if (!Utility.controlGiorno(dataConsegna))
			throw new DataException("Giorno della consegna errato nella riga: " + Utility.vetToString(vet));
		
		if (!Utility.controlMese(dataOrdine))
			throw new DataException("Mese ordine errato nella riga: " + Utility.vetToString(vet));
		
		if (!Utility.controlMese(dataConsegna))
			throw new DataException("Mese consegna errato nella riga: " + Utility.vetToString(vet));
		
		if (!Utility.controlAnno(dataOrdine))
			throw new DataException("Anno ordine errato nella riga: " + Utility.vetToString(vet));
		
		if (!Utility.controlAnno(dataConsegna))
			throw new DataException("Anno consegna errato nella riga: " + Utility.vetToString(vet));
		
		if(!Utility.confrontaDate(dataOrdine, dataConsegna))
			throw new DataException("La data dell'ordine non puo' essere "
					+ "maggiore della data di consegna. "
					+ "Errore nella riga: " + Utility.vetToString(vet));
		
	}
	
	public void controllaOutlet(String[] vet) throws OutletException{
		
		if ((Integer.parseInt(outlet) != 1) && (Integer.parseInt(outlet) != 0))
			throw new OutletException(Utility.vetToString(vet));
		if (Integer.parseInt(outlet)==1) {
			setOutlet("NO");
		}else {
			setOutlet("SI");
		}
		
	}
	
	public String toString() {
		return idOrdine + ";" + idCorriere + ";" + dataOrdine + ";" +
				dataConsegna + ";" + codStatoFattura + ";" +
				codProvinciaFattura + ";" + comuneFatturazione + ";" +
				totaleImponibileFattura + ";" + totaleConIva +";" +
				idCliente + ";" +  sesso + ";" + quantita  + ";" +
				idMagazzino  + ";" + prezzoVendita  + ";" + prezzoPieno  + ";" +
				prezzoScontato  + ";" + sconto  + ";" + outlet  + ";" +
				idTaglia2  + ";" + nomeDes  + ";" + linguaCollezione  + ";" +
					 linguaColore  + ";" + nomeSes  + ";" + pagamentoOrdine  + ";" +
				 idGruppoTaglie  + ";" + nomeCat  + ";" + nomeMac;
		 
	}
	/**
	 * verifica se la citt� � dello stesso stato
	 */
	public void controllaStato(String []vet) throws StatoException {
		if (controllaProvincia() && !codStatoFattura.equals("IT")) {
			throw new StatoException("CodStatoFattura errato nella riga " + Utility.vetToString(vet));
		}
	}
	
	/**
	 * verifica se la provincia � italiana
	 * @return
	 */
	public boolean controllaProvincia() {
		
		boolean trovato = false;
		for (int i = 0; i < provincia.size(); i++) {
			if (getCodProvinciaFattura().equals(provincia.get(i).getSigla())) {
				trovato = true;
				break;
			}
				
		} 
		return trovato;
		
	}
	
	public void setProvincia() {
		provincia = new ArrayList<Provincia>();
		provincia.add(new Provincia("AG", "Isole"));
		provincia.add(new Provincia("AL", "Nord"));
		provincia.add(new Provincia("AN", "Centro"));
		provincia.add(new Provincia("AO", "Nord"));
		provincia.add(new Provincia("AR", "Centro"));
		provincia.add(new Provincia("AP", "Centro"));
		provincia.add(new Provincia("AT", "Nord"));
		provincia.add(new Provincia("AV", "Sud"));
		provincia.add(new Provincia("BA", "Sud"));
		provincia.add(new Provincia("BT", "Sud"));
		provincia.add(new Provincia("BL", "Nord"));
		provincia.add(new Provincia("BN", "Sud"));
		provincia.add(new Provincia("BG", "Nord"));
		provincia.add(new Provincia("BI", "Nord"));
		provincia.add(new Provincia("BO", "Nord"));
		provincia.add(new Provincia("BZ", "Nord"));
		provincia.add(new Provincia("BS", "Nord"));
		provincia.add(new Provincia("BR", "Sud"));
		provincia.add(new Provincia("CA", "Isole"));
		provincia.add(new Provincia("CL", "Isole"));
		provincia.add(new Provincia("CB", "Sud"));
		provincia.add(new Provincia("CE", "Sud"));
		provincia.add(new Provincia("CI", "Isole"));
		provincia.add(new Provincia("CT", "Isole"));
		provincia.add(new Provincia("CR", "Nord"));
		provincia.add(new Provincia("CO", "Nord"));
		provincia.add(new Provincia("CH", "Sud"));
		provincia.add(new Provincia("CS", "Sud"));
		provincia.add(new Provincia("CN", "Nord"));
		provincia.add(new Provincia("CZ", "Sud"));
		provincia.add(new Provincia("EN", "Isole"));
		provincia.add(new Provincia("FE", "Nord"));
		provincia.add(new Provincia("FC", "Nord"));
		provincia.add(new Provincia("FG", "Sud"));
		provincia.add(new Provincia("FI", "Centro"));
		provincia.add(new Provincia("FM", "Centro"));
		provincia.add(new Provincia("FR", "Centro"));
		provincia.add(new Provincia("GE", "Nord"));
		provincia.add(new Provincia("GO", "Nord"));
		provincia.add(new Provincia("GR", "Centro"));
		provincia.add(new Provincia("IM", "Nord"));
		provincia.add(new Provincia("IS", "Sud"));
		provincia.add(new Provincia("KR", "Sud"));
		provincia.add(new Provincia("LC", "Nord"));
		provincia.add(new Provincia("LE", "Sud"));
		provincia.add(new Provincia("LO", "Nord"));
		provincia.add(new Provincia("LU", "Centro"));
		provincia.add(new Provincia("LI", "Centro"));
		provincia.add(new Provincia("LT", "Centro"));
		provincia.add(new Provincia("MN", "Nord"));
		provincia.add(new Provincia("MS", "Centro"));
		provincia.add(new Provincia("MT", "Sud"));
		provincia.add(new Provincia("MI", "Nord"));
		provincia.add(new Provincia("MO", "Nord"));
		provincia.add(new Provincia("MC", "Centro"));
		provincia.add(new Provincia("MB", "Nord"));
		provincia.add(new Provincia("ME", "Isole"));
		provincia.add(new Provincia("NA", "Sud"));
		provincia.add(new Provincia("NO", "Nord"));
		provincia.add(new Provincia("NU", "Isole"));
		provincia.add(new Provincia("OR", "Isole"));
		provincia.add(new Provincia("OG", "Isole"));
		provincia.add(new Provincia("OT", "Isole"));
		provincia.add(new Provincia("PD", "Nord"));
		provincia.add(new Provincia("PV", "Nord"));
		provincia.add(new Provincia("PN", "Nord"));
		provincia.add(new Provincia("PC", "Nord"));
		provincia.add(new Provincia("PR", "Nord"));
		provincia.add(new Provincia("PT", "Centro"));
		provincia.add(new Provincia("PI", "Centro"));
		provincia.add(new Provincia("PO", "Centro"));
		provincia.add(new Provincia("PG", "Centro"));
		provincia.add(new Provincia("PU", "Centro"));
		provincia.add(new Provincia("PE", "Sud"));
		provincia.add(new Provincia("PZ", "Sud"));
		provincia.add(new Provincia("RO", "Nord"));
		provincia.add(new Provincia("RA", "Nord"));
		provincia.add(new Provincia("RE", "Nord"));
		provincia.add(new Provincia("RN", "Nord"));
		provincia.add(new Provincia("RI", "Centro"));
		provincia.add(new Provincia("RM", "Centro"));
		provincia.add(new Provincia("RC", "Sud"));
		provincia.add(new Provincia("RG", "Isole"));
		provincia.add(new Provincia("SO", "Nord"));
		provincia.add(new Provincia("SV", "Nord"));
		provincia.add(new Provincia("SP", "Nord"));
		provincia.add(new Provincia("SI", "Centro"));
		provincia.add(new Provincia("SA", "Sud"));
		provincia.add(new Provincia("SR", "Isole"));
		provincia.add(new Provincia("SS", "Isole"));
		provincia.add(new Provincia("SU", "Isole"));
		provincia.add(new Provincia("TO", "Nord"));
		provincia.add(new Provincia("TN", "Nord"));
		provincia.add(new Provincia("TV", "Nord"));
		provincia.add(new Provincia("TS", "Nord"));
		provincia.add(new Provincia("TR", "Centro"));
		provincia.add(new Provincia("TE", "Sud"));
		provincia.add(new Provincia("TA", "Sud"));
		provincia.add(new Provincia("TP", "Isole"));
		provincia.add(new Provincia("UD", "Nord"));
		provincia.add(new Provincia("VC", "Nord"));
		provincia.add(new Provincia("VB", "Nord"));
		provincia.add(new Provincia("VO", "Nord"));
		provincia.add(new Provincia("VR", "Nord"));
		provincia.add(new Provincia("VI", "Nord"));
		provincia.add(new Provincia("VE", "Nord"));
		provincia.add(new Provincia("VT", "Centro"));
		provincia.add(new Provincia("VV", "Sud"));

	}
	
}
