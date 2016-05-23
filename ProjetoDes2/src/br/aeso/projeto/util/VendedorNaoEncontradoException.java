package br.aeso.projeto.util;

public class VendedorNaoEncontradoException extends Exception{
	public VendedorNaoEncontradoException(){
		super("Vendedor não encontrado");
	}
}
