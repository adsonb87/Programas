package br.aeso.projeto.util;

public class ListaNotaFiscalNaoEncontradaException extends Exception{
	public ListaNotaFiscalNaoEncontradaException(){
		super("Lista de notas fiscais vazia");
	}
}
