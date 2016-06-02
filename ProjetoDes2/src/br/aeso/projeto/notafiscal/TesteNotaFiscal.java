package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
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
		
		IRepositorioNotaFiscal repositorioNotaFiscal = new RepositorioNotaFiscalArray();
		IRepositorioProduto repositorioProduto = new RepositorioProdutoArray();
		IRepositorioPedido repositorioPedido = new RepositorioPedidoArray();

		produto = new Produto("1", "Salgadinho de cebola", 3.50, "dataVencimento");
		repositorioProduto.cadastrar(produto);
		produto = new Produto("2", "Salgadinho de frango", 3, "dataVencimento");
		repositorioProduto.cadastrar(produto);
		produto = new Produto("3", "Salgadinho de queijo", 2.50, "dataVencimento");
		repositorioProduto.cadastrar(produto);
		
		notaFiscal = new NotaFiscal("1", cliente, vendedor);
		
		pedido = new Pedido(notaFiscal, "1", repositorioProduto.procurar("1"), 10);
		repositorioPedido.cadastrar(pedido);
		notaFiscal.adicionarPedido(pedido);
		
		pedido = new Pedido(notaFiscal, "2", repositorioProduto.procurar("2"), 20);
		repositorioPedido.cadastrar(pedido);
		notaFiscal.adicionarPedido(pedido);
		
		
		pedido = new Pedido(notaFiscal, "3", repositorioProduto.procurar("3"), 25);
		repositorioPedido.cadastrar(pedido);
		notaFiscal.adicionarPedido(pedido);
		
		ArrayList<Pedido> pedidos = new ArrayList<>();
		pedidos = repositorioPedido.listar();
		
		System.out.println(pedido.toString());
		
		repositorioNotaFiscal.cadastrar(notaFiscal);
		System.out.println("Nota Fiscal: \n"+repositorioNotaFiscal.listar().toString());
		
	}

}