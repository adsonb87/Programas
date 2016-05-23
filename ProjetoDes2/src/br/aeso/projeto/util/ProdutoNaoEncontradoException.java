package br.aeso.projeto.util;

import br.aeso.projeto.produto.Produto;

public class ProdutoNaoEncontradoException extends Exception{
	public ProdutoNaoEncontradoException(){
		super("Produto não encontrado");
	}
}
