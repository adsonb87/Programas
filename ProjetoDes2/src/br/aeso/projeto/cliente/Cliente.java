package br.aeso.projeto.cliente;

public class Cliente {
	private String codigoCliente;
	private String nome;
	private String endereco;
	private  String telefone;
	
	public Cliente(String codigoCliente, String nome, String endereco, String telefone){
		this.codigoCliente = codigoCliente;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone= telefone;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	@Override
	public String toString() {
		return "Cliente\nCodigo: " + codigoCliente + "\nNome: " + nome + "\nEndereco: " + endereco + "\nTelefone: "
				+ telefone + "\n-----\n";
	}
	
	
	
}
