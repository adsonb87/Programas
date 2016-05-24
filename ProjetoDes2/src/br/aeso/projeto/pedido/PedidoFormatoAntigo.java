package br.aeso.projeto.pedido;

import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.vendedor.Vendedor;

public class PedidoFormatoAntigo {
	
	private String codigoPedido;
	private String codigoProduto;
	private String nomeProduto;
	private String codigoVendedor;
	private String nomeVendedor;
	private double quantidadeProduto;
	private double precoProduto;
	
	public PedidoFormatoAntigo(String codigoPedido, Vendedor vendedor, Produto produto, double quantidadeProduto){
		this.codigoPedido = codigoPedido;
		this.codigoVendedor = vendedor.getCodigoVendedor();
		this.nomeVendedor = vendedor.getNome();
		this.codigoProduto = produto.getCodigoProduto();
		this.nomeProduto = produto.getNome();
		this.precoProduto = produto.getPrecoProduto();
		this.quantidadeProduto = quantidadeProduto;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public double getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(double quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	@Override
	public String toString() {
		return "Pedido [codigoPedido=" + codigoPedido + ", codigoProduto=" + codigoProduto + ", nomeProduto="
				+ nomeProduto + ", codigoVendedor=" + codigoVendedor + ", nomeVendedor=" + nomeVendedor
				+ ", quantidadeProduto=" + quantidadeProduto + ", precoProduto=" + precoProduto + "]";
	}
	
}
