package br.aeso.projeto.util;

public class NotaFiscalNaoEncontradaException extends Exception{
	public NotaFiscalNaoEncontradaException(){
		super("Nota Fiscal n�o encontrada");
	}
}
