package br.aeso.projeto.util;

public class FornecedorNaoEncontradoException extends Exception{
	public FornecedorNaoEncontradoException(){
		super("Fornecedor n�o encontrado");
	}
}
