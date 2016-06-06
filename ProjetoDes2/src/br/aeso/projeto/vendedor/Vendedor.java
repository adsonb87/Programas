package br.aeso.projeto.vendedor;

import java.io.Serializable;

public class Vendedor implements Serializable{
	private String codigoVendedor;
	private String nome;
	private String endereco;
	private String telefone;
	
	public Vendedor(String codigoVendedor, String nome, String endereco, String telefone){
		this.codigoVendedor = codigoVendedor;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
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
		return "Vendedor\nCodigo: " + codigoVendedor + "\nNome: " + nome + "\nEndereco: " + endereco
				+ "\nTelefone: " + telefone + "\n-----\n";
	}
	
	
}
