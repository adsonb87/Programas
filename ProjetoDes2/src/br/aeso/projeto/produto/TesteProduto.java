package br.aeso.projeto.produto;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;

public class TesteProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto produto = new Produto("001", "nome", 3.50, "dataVencimento");
		RepositorioProdutoArray repo = new RepositorioProdutoArray();
		
		Fachada fachada = Fachada.getInstance();
		ControladorProduto c = new ControladorProduto();
		
		try {
			fachada.cadastrarProduto(produto);
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(fachada.listarProduto());
		
		try {
			System.out.println(fachada.removerProduto(produto.getCodigoProduto()));
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(fachada.listarProduto());
	}

}
