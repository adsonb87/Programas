package br.aeso.projeto.pedido;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;

public class ControladorPedido {
	
	private IRepositorioPedido repositorioPedido;
	
	public ControladorPedido(){
		repositorioPedido = new RepositorioPedidoArray();
	}
	
	public void cadastrarPedido(Pedido pedido) throws PedidoNaoEncontradoException{
		repositorioPedido.cadastrar(pedido);
	}
	
	public void atualizarPedido(Pedido pedido) throws CodigoInexistenteException{
		repositorioPedido.atualizar(pedido);
	}
	
	public boolean removerPedido(String codigo) throws CodigoInexistenteException, PedidoNaoEncontradoException{
		if(repositorioPedido.existe(codigo)){
			repositorioPedido.remover(repositorioPedido.procurar(codigo));
			return true;
		}else{
			return false;
		}
	}
	
	public Pedido procurarPedido(String codigo) throws CodigoInexistenteException{
		return repositorioPedido.procurar(codigo);
	}
	
	public void listarPedido(String codigo) throws CodigoInexistenteException{
		repositorioPedido.listarTudo(codigo);
	}

}
