package entity;

import control.Tela;



public class Programa {

private int id;	
private String nome;
private String genero;
private String horarioFim;
private String horarioInicio;



	public Programa(int id,String nome, String genero,String horarioFim, String horarioInicio) {
	super();
	this.id = id;
	this.nome = nome;
	this.genero = genero;
	this.horarioFim = horarioFim;
	this.horarioInicio = horarioInicio;

}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getHorarioFim() {
		return horarioFim;
	}



	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}



	public String getHorarioInicio() {
		return horarioInicio;
	}



	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}


  @Override
	public String toString() {
		return "Programa [id=" + id + ", nome=" + nome + ", genero=" + genero
				+ ", horarioFim=" + horarioFim + ", horarioInicio="
				+ horarioInicio + "]";
	}



public static void main(String[] args) {
		
		
		

  }
}
