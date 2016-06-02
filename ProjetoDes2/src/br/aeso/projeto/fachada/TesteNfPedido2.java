package br.aeso.projeto.fachada;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.notafiscal.NotaFiscal;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.NotaFiscalNaoEncontradaException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;
import br.aeso.projeto.vendedor.Vendedor;

public class TesteNfPedido2 {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("01", "Adson", "endereco", "telefone");
		Vendedor vendedor = new Vendedor("01", "Ozeias", "endereco", "telefone");
		Produto produto;
		Pedido pedido;
		NotaFiscal notaFiscal;
		
		Fachada fachada = Fachada.getInstance();
		
		
		try {
			fachada.cadastrarCliente(cliente);
			fachada.cadastrarVendedor(vendedor);
		} catch (VendedorNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClienteNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			produto = new Produto("01", "nome1", 2, "dataVencimento");
			fachada.cadastrarProduto(produto);
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			produto = new Produto("02", "nome2", 3, "dataVencimento");
			fachada.cadastrarProduto(produto);
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("Cliente: "+ fachada.listarCliente().toString()+"\n Vendedor " + 
//				fachada.listarVendedor().toString() +"Produto: "+ fachada.listarProduto().toString());

		
		try {
			notaFiscal = new NotaFiscal("1", fachada.procurarCliente("01"), fachada.procurarVendedor("01"));
			fachada.cadastrarNotaFiscal(notaFiscal);
		} catch (CodigoInexistenteException | NotaFiscalNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(fachada.listarNotaFiscal());
		
		try {
			pedido = new Pedido(fachada.procurarNotaFiscal("1"), "01", fachada.procurarProduto("01"), 10);
			fachada.cadastrarPedido(pedido);
		} catch (CodigoInexistenteException | PedidoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pedido = new Pedido(fachada.procurarNotaFiscal("1"), "02", fachada.procurarProduto("02"), 10);
			fachada.cadastrarPedido(pedido);
		} catch (CodigoInexistenteException | PedidoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			fachada.procurarNotaFiscal("1").adicionarPedido(fachada.procurarPedido("01"));
			fachada.procurarNotaFiscal("1").adicionarPedido(fachada.procurarPedido("02"));
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(fachada.listarNotaFiscal());

	}

}
