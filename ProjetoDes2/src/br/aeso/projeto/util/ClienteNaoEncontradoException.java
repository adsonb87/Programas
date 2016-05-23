package br.aeso.projeto.util;

public class ClienteNaoEncontradoException extends Exception{
	public ClienteNaoEncontradoException(){
		super("O Cliente não está cadastrado");
	}
}
