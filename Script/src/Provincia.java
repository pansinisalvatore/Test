
public class Provincia {

	private String sigla;
	private String posizione;
	
	public Provincia(String sigla, String posizione ) {
		this.setSigla(sigla);
		this.setPosizione(posizione);
	}
	
	public Provincia() {
		setSigla("");
		setPosizione("");
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	
	public void set(String sigla, String posizione) {
		this.sigla = sigla;
		this.posizione = posizione;
	}
	
	
}
