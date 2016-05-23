package br.aeso.projeto.produto;

public class Produto {
	private String codigoProduto;
	private String nome;
	private double precoProduto;
	private String dataVencimento;
	
	public Produto(String codigoProduto, String nome, double precoProduto, String dataVencimento){
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.precoProduto = precoProduto;
		this.dataVencimento = dataVencimento;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getData() {
		return dataVencimento;
	}

	public void setData(String data) {
		this.dataVencimento = data;
	}

	
	@Override
	public String toString() {
		return "Produto [codigoProduto=" + codigoProduto + ", nome=" + nome + ", precoProduto=" + precoProduto
				+ ", dataVencimento=" + dataVencimento + "]\n";
	}
	
	
}
