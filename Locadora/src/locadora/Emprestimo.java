package locadora;

public class Emprestimo {
	

	private String cliente;
	private String fita;
	
	public Emprestimo(String cliente, String fita) {
		super();

		this.cliente = cliente;
		this.fita = fita;
	}



	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFita() {
		return fita;
	}

	public void setFita(String fita) {
		this.fita = fita;
	}



	@Override
	public String toString() {
		return "Emprestimo [cliente=" + cliente + ", fita=" + fita + "]";
	}


	

}
