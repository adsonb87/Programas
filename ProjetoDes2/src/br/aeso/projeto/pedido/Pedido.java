package br.aeso.projeto.pedido;

import java.util.ArrayList;

import br.aeso.projeto.notafiscal.NotaFiscal;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.vendedor.Vendedor;

public class Pedido {
	
	private NotaFiscal notaFiscal;
	private String codigoPedido;
	private Produto produto;
	private double quantidadeProduto;
	
	public Pedido(NotaFiscal notaFiscal, String codigoPedido, Produto produto, double quantidadeProduto){
		this.notaFiscal = notaFiscal;
		this.codigoPedido = codigoPedido;
		this.produto = produto;
		this.quantidadeProduto = quantidadeProduto;
	}

	public NotaFiscal getNotaFiscal() {
		return this.notaFiscal;
	}
	
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(double quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	@Override
	public String toString() {
		return "Pedido\nNota Fiscal: " + notaFiscal.getCodigoNotaFiscal() + "\nCodigo Pedido: " + codigoPedido + " Nome Produto: " + produto.getNome()+ " Preco Produto: " 
	+ produto.getPrecoProduto() +" Quantidade Produto: " + quantidadeProduto + " Preco Pedido: " + quantidadeProduto*produto.getPrecoProduto() + "\n-----\n";
	}
	
	
}
