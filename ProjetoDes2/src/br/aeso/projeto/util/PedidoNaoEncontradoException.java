package br.aeso.projeto.util;

import br.aeso.projeto.pedido.Pedido;

public class PedidoNaoEncontradoException extends Exception{
	public PedidoNaoEncontradoException(){
		super("Pedido não encontrado");
	}
}
