package br.aeso.projeto.produto;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaProdutoVaziaException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;

public class ControladorProduto {
	
	private IRepositorioProduto repositorioProduto;
	
	public ControladorProduto(){
		repositorioProduto = new RepositorioProdutoArray();
	}
	
	public void cadastrarProduto(Produto produto) throws ProdutoNaoEncontradoException{
		repositorioProduto.cadastrar(produto);
	}
	
	public void atualizarProduto(Produto produto) throws CodigoInexistenteException{
		repositorioProduto.atualizar(produto);
	}
	
	public boolean removerProduto(String codigo) throws CodigoInexistenteException, ProdutoNaoEncontradoException{
		if(repositorioProduto.existe(codigo)){
			repositorioProduto.remover(repositorioProduto.procurar(codigo));
			return true;
		}else{
			return false;
		}
	}
	
	public Produto procurarProduto(String codigo) throws CodigoInexistenteException{
		return repositorioProduto.procurar(codigo);
	}
	
	public ArrayList<Produto> listarProduto() throws ListaProdutoVaziaException{
		return repositorioProduto.listar();
	}
	
}
