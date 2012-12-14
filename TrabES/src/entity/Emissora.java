package entity;

public class Emissora {

	private String emissora;
	private String genero;
	
	
	public Emissora(String emissora, String genero) {
		super();
		this.emissora = emissora;
		this.genero = genero;
	}


	public String getEmissora() {
		return emissora;
	}


	public void setEmissora(String emissora) {
		this.emissora = emissora;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	
}