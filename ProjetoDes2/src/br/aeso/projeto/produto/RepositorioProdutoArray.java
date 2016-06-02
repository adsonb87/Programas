package br.aeso.projeto.produto;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaFornecedorVaziaException;
import br.aeso.projeto.util.ListaProdutoVaziaException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;

public class RepositorioProdutoArray implements IRepositorioProduto{
	
	private ArrayList<Produto> listaProduto;
	
	public RepositorioProdutoArray() {
		listaProduto = new ArrayList<Produto>();
	}
	
	@Override
	public void cadastrar(Produto produto){
		if(existe(produto.getCodigoProduto())){
			listaProduto.add(produto);
		}
	}

	@Override
	public void atualizar(Produto produto){
		if(existe(produto.getCodigoProduto())){
			for(int i=0;i<listaProduto.size();i++){
				if(listaProduto.get(i).getCodigoProduto().equals(produto.getCodigoProduto())){
					listaProduto.set(i, produto);
//					listaProduto.get(i).setCodigoProduto(produto.getCodigoProduto());
//					listaProduto.get(i).setNome(produto.getNome());
//					listaProduto.get(i).setData(produto.getData());
//					listaProduto.get(i).setPrecoProduto(produto.getPrecoProduto());
				}
			}
		}
	}

	@Override
	public boolean remover(Produto produto){
		if(existe(produto.getCodigoProduto())){
			listaProduto.remove(produto);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Produto procurar(String codigo){
		if(existe(codigo)){
			for(int i=0; i<listaProduto.size();i++){
				if(listaProduto.get(i).getCodigoProduto().equals(codigo)){
					return listaProduto.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(String codigo){
		if(codigo != null){
			for(int i=0;i<listaProduto.size();i++){
				if(listaProduto.get(i).getCodigoProduto().equals(codigo)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Produto> listar(){
		return listaProduto;
		
	}

}
