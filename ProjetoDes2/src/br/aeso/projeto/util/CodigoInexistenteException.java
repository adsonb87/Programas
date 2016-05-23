package br.aeso.projeto.util;

public class CodigoInexistenteException extends Exception{
	public CodigoInexistenteException(){
		super("Codigo inexistente");
	}
}
