package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.pedido.IRepositorioPedido;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.pedido.RepositorioPedidoArray;
import br.aeso.projeto.produto.IRepositorioProduto;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.produto.RepositorioProdutoArray;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaNotaFiscalNaoEncontradaException;
import br.aeso.projeto.util.ListaPedidoVaziaException;
import br.aeso.projeto.util.NotaFiscalNaoEncontradaException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;
import br.aeso.projeto.vendedor.Vendedor;

public class TesteNotaFiscal {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("1", "adson", "endereco", "telefone");
		Vendedor vendedor = new Vendedor("1", "Armando", "endereco", "telefone");
		
		Pedido pedido;
		Produto produto;
		NotaFiscal notaFiscal;
		
		Fachada fachada = Fachada.getInstance();
		
		produto = new Produto("1", "Salgadinho de cebola", 3.50, "dataVencimento");
		try {
			fachada.cadastrarProduto(produto);
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		produto = new Produto("2", "Salgadinho de frango", 3, "dataVencimento");
		try {
			fachada.cadastrarProduto(produto);
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		produto = new Produto("3", "Salgadinho de queijo", 2.50, "dataVencimento");
		try {
			fachada.cadastrarProduto(produto);
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		notaFiscal = new NotaFiscal("1", cliente, vendedor);
		try {
			fachada.cadastrarNotaFiscal(notaFiscal);
		} catch (NotaFiscalNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pedido = new Pedido(notaFiscal, "1", fachada.procurarProduto("1"), 10);
			notaFiscal.adicionarPedido(pedido);
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(fachada.listarNotaFiscal().toString());
		
		
		
		
		
		
		
	}

}