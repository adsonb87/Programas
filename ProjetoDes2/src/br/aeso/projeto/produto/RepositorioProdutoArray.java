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
	public void cadastrar(Produto produto) throws ProdutoNaoEncontradoException{
		if(produto.getCodigoProduto() != null){
			listaProduto.add(produto);
		}else{
			throw new ProdutoNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Produto produto)throws CodigoInexistenteException{
		if(produto.getCodigoProduto() != null){
			for(int i=0;i<listaProduto.size();i++){
				if(listaProduto.get(i).getCodigoProduto().equals(produto.getCodigoProduto())){
					listaProduto.get(i).setCodigoProduto(produto.getCodigoProduto());
					listaProduto.get(i).setNome(produto.getNome());
					listaProduto.get(i).setData(produto.getData());
					listaProduto.get(i).setPrecoProduto(produto.getPrecoProduto());
				}
			}
		}else{
			throw new CodigoInexistenteException();
		}
		
	}

	@Override
	public boolean remover(Produto produto) throws ProdutoNaoEncontradoException  {
		if(produto.getCodigoProduto() != null){
			if(listaProduto.contains(produto)){
				listaProduto.remove(produto);
				return true;
			}else{
				return false;
			}
		}else{
			throw new ProdutoNaoEncontradoException();
		}
	}

	@Override
	public Produto procurar(String codigo)throws CodigoInexistenteException {
		if(codigo != null){
			for(int i=0; i<listaProduto.size();i++){
				if(listaProduto.get(i).getCodigoProduto().equals(codigo)){
					return listaProduto.get(i);
				}
			}
			return null;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean existe(String codigo) throws CodigoInexistenteException{
		if(codigo != null){
			for(int i=0;i<listaProduto.size();i++){
				if(listaProduto.get(i).getCodigoProduto().equals(codigo)){
					return true;
				}
			}
			return false;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public ArrayList<Produto> listar() throws ListaProdutoVaziaException{
		if(!listaProduto.isEmpty()){
			return listaProduto;
		}else{
			throw new ListaProdutoVaziaException();
		}
	}

}
