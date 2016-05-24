package br.aeso.projeto.pedido;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaPedidoVaziaException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;

public interface IRepositorioPedido {
	public void cadastrar (Pedido pedido) throws PedidoNaoEncontradoException;
	public void atualizar (Pedido pedido) throws CodigoInexistenteException;
	public boolean remover (Pedido pedido) throws PedidoNaoEncontradoException;
	public Pedido procurar (String codigo) throws CodigoInexistenteException;
	public boolean existe (String codigo) throws CodigoInexistenteException;
	public ArrayList<Pedido> listar() throws ListaPedidoVaziaException;
}
