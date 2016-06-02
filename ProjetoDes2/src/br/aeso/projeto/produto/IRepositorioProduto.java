package br.aeso.projeto.produto;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaProdutoVaziaException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;

public interface IRepositorioProduto {
	
	public void cadastrar (Produto produto);
	public void atualizar (Produto produto);
	public boolean remover (Produto produto);
	public Produto procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<Produto> listar();
}
