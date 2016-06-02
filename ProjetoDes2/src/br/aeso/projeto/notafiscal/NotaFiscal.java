package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.vendedor.Vendedor;

public class NotaFiscal {
	
	private String codigoNotaFiscal;
	private Cliente cliente;
	private ArrayList<Pedido> pedidos;
	private Vendedor vendedor;
	
	public NotaFiscal(String codigoNotaFiscal, Cliente cliente, Vendedor vendedor){
		this.codigoNotaFiscal = codigoNotaFiscal;
		this.cliente = cliente;
		this.vendedor = vendedor;
		pedidos = new ArrayList<Pedido>();
	}

	public String getCodigoNotaFiscal() {
		return codigoNotaFiscal;
	}

	public void setCodigoNotaFiscal(String codigoNotaFiscal) {
		this.codigoNotaFiscal = codigoNotaFiscal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void adicionarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public double getValorTotalNotaFiscal() {
		double total = 0;
		for(Pedido pedido : pedidos) {
			total += (pedido.getQuantidadeProduto() * pedido.getProduto().getPrecoProduto());
		}
		return total;
	}

	@Override
	public String toString() {
		return "NotaFiscal [codigoNotaFiscal=" + codigoNotaFiscal + "\n cliente=" + cliente.getCodigoCliente() + " - "+cliente.getNome()+"\n pedidos= \n" + pedidos.toString()
		+ "valorTotalDaNota= "+getValorTotalNotaFiscal()+"\n vendedor=" + vendedor.getCodigoVendedor()+" - " +vendedor.getNome()+ "]";
	}
	
	
	
}
