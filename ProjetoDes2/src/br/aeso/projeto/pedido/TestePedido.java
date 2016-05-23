package br.aeso.projeto.pedido;

import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;
import br.aeso.projeto.vendedor.Vendedor;

public class TestePedido {

	public static void main(String[] args) {
		
		Produto pr = new Produto("01", "Salgadinho de cebola", 4, "10/10/2015");
		Produto pr1 = new Produto("02", "Salgadinho de frango", 5, "10/10/2015");
		Vendedor v = new Vendedor("01", "Ozeias", "Av. nacional", "00000");
		Vendedor v1 = new Vendedor("02", "Baubino", "Av. nacional", "00000");
		RepositorioPedidoArray r = new RepositorioPedidoArray();
		
		Pedido pedido;
		
		
		try {
			pedido = new Pedido("01", v1, pr, 10);
			r.cadastrar(pedido);
		} catch (PedidoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			pedido = new Pedido("01", v1, pr1, 10);
			r.cadastrar(pedido);
		} catch (PedidoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			pedido = new Pedido("01", v1, pr1, 20);
			r.cadastrar(pedido);
		} catch (PedidoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			pedido = new Pedido("01", v1, pr, 30);
			r.cadastrar(pedido);
		} catch (PedidoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			pedido = new Pedido("02", v, pr, 30);
			r.cadastrar(pedido);
		} catch (PedidoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			r.listarTudo("04");
		} catch (CodigoInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
