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
		if(produto.getCodigoProduto() != null){
			repositorioProduto.cadastrar(produto);
		}else{
			throw new ProdutoNaoEncontradoException();
		}
	}
	
	public void atualizarProduto(Produto produto) throws CodigoInexistenteException{
		if(produto.getCodigoProduto()!=null){
			repositorioProduto.atualizar(produto);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public boolean removerProduto(String codigo) throws CodigoInexistenteException{
		if(codigo!=null){
			if(repositorioProduto.existe(codigo)){
				repositorioProduto.remover(repositorioProduto.procurar(codigo));
				return true;
			}else{
				return false;
			}
		}else{
			throw new CodigoInexistenteException();		
		}
	}
	
	public Produto procurarProduto(String codigo) throws CodigoInexistenteException{
		if(codigo!=null){
			return repositorioProduto.procurar(codigo);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public ArrayList<Produto> listarProduto(){
		return repositorioProduto.listar();
	}
	
}
