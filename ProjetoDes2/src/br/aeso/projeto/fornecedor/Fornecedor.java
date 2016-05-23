package br.aeso.projeto.fornecedor;

public class Fornecedor {
	private String codigoFornecedor;
	private String nome;
	private String endereco;
	private String telefone;
	
	public Fornecedor(String codigoFornecedor, String nome, String endereco, String telefone){
		this.codigoFornecedor = codigoFornecedor;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(String codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
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
		return "Fornecedor [codigoFornecedor=" + codigoFornecedor + ", nome=" + nome + ", endereco=" + endereco
				+ ", telefone=" + telefone + "]\n";
	}
	
	
}
