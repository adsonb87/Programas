package br.aeso.projeto.pedido;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.notafiscal.NotaFiscal;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaPedidoVaziaException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;
import br.aeso.projeto.vendedor.Vendedor;

public class TestePedido {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("1", "Bina", "endereco", "telefone");
		Vendedor vendedor = new Vendedor("2", "Manoel", "endereco", "telefone");
			
		NotaFiscal notaFiscal = new NotaFiscal("1", cliente, vendedor);
		
		Pedido pedido = new Pedido(notaFiscal, "1", new Produto("123", "Papel", 10, "12/12/2017"), 10);
		Pedido pedido2 = new Pedido(notaFiscal, "2", new Produto("321", "Papel2", 20, "12/12/2017"), 5);
		Pedido pedido3 = new Pedido(notaFiscal, "3", new Produto("567", "Papel3", 30, "12/12/2017"), 1);
		
		IRepositorioPedido repositorio = new RepositorioPedidoArray();
		
		try {
			repositorio.cadastrar(pedido);
			repositorio.cadastrar(pedido2);
			repositorio.cadastrar(pedido3);
		} catch (PedidoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<Pedido> lista = repositorio.listar();
			System.out.println(lista.toString());
		} catch (ListaPedidoVaziaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pedido.setQuantidadeProduto(1);
		try {
			repositorio.atualizar(pedido);
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<Pedido> lista = repositorio.listar();
			System.out.println(lista.toString());
		} catch (ListaPedidoVaziaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
