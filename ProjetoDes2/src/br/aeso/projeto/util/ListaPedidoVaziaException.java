package br.aeso.projeto.util;

public class ListaPedidoVaziaException extends Exception{
	public ListaPedidoVaziaException(){
		super("Lista de pedidos est� vazia");
	}
}
