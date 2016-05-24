package br.aeso.projeto.gui;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.fornecedor.Fornecedor;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;
import br.aeso.projeto.vendedor.Vendedor;

public class TesteFachada {

	public static void main(String[] args) {
		
		Fachada fc = new Fachada();
		
		Cliente cliente;
		Fornecedor fornecedor;
		Produto produto;
		Vendedor vendedor;
		Pedido pedido;
		
		cliente = new Cliente("01", "Adson", "Rua 25 de Janeiro, 439", "(81)999468642");
		fornecedor = new Fornecedor("01", "Baubino Distribuidora", "Av. Perimetral, 1002", "(81)34273460");
		produto = new Produto("01", "Salgadinho de cebola", 3.50,"14/10/2016");
		vendedor = new Vendedor("01", "Alexandre", "Av. nacional, 129", "(81)998789999");
		
		
	
		
		try {
			fc.cadastrarCliente(c);
		} catch (ClienteNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fc.cadastrarFornecedor(f);
		} catch (FornecedorNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fc.cadastrarProduto(p);
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fc.cadastrarVendedor(v);
		} catch (VendedorNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			System.out.println("Listagens\nLista clientes: "+fc.listarCliente()+"\nLista Fornecedor: "+fc.listarFornecedor()+"\nLista Produto: "+fc.listarProduto()+"\nLista vendedor: "+fc.listarVendedor());
//		} catch (ListaClienteVaziaException | ListaFornecedorVaziaException | ListaProdutoVaziaException
//				| ListaVendedorVaziaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			fc.cadastrarPedido(pd);
		} catch (PedidoNaoEncontradoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		try {
			fc.listarPedido("01");
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
