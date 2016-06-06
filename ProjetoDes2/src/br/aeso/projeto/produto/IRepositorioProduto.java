package br.aeso.projeto.produto;

import java.util.ArrayList;

public interface IRepositorioProduto {
	
	public void cadastrar (Produto produto);
	public void atualizar (Produto produto);
	public boolean remover (Produto produto);
	public Produto procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<Produto> listar();
}
