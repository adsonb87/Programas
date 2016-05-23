package br.aeso.projeto.produto;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaProdutoVaziaException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;

public interface IRepositorioProduto {
	
	public void cadastrar (Produto produto) throws ProdutoNaoEncontradoException;
	public void atualizar (Produto produto) throws CodigoInexistenteException;
	public boolean remover (Produto produto) throws ProdutoNaoEncontradoException;
	public Produto procurar (String codigo) throws CodigoInexistenteException;
	public boolean existe (String codigo) throws CodigoInexistenteException;
	public ArrayList<Produto> listar() throws ListaProdutoVaziaException;
}
