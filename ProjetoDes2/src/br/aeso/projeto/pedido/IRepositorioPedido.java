package br.aeso.projeto.pedido;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaPedidoVaziaException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;

public interface IRepositorioPedido {
	public void cadastrar (Pedido pedido);
	public void atualizar (Pedido pedido);
	public boolean remover (Pedido pedido);
	public Pedido procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<Pedido> listar();
}
