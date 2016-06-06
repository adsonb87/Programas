package br.aeso.projeto.pedido;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;

public class ControladorPedido {
	
	private IRepositorioPedido repositorioPedido;
	
	public ControladorPedido(){
		repositorioPedido = new RepositorioPedidoArray();
	}
	
	public void cadastrarPedido(Pedido pedido) throws PedidoNaoEncontradoException{
		if(pedido.getCodigoPedido()!=null){
			repositorioPedido.cadastrar(pedido);
		}else{
			throw new PedidoNaoEncontradoException();
		}
	}
	
	public void atualizarPedido(Pedido pedido) throws CodigoInexistenteException{
		if(pedido.getCodigoPedido()!=null){
			repositorioPedido.atualizar(pedido);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public boolean removerPedido(String codigo) throws CodigoInexistenteException{
		if(codigo!=null){
			if(repositorioPedido.existe(codigo)){
				repositorioPedido.remover(repositorioPedido.procurar(codigo));
				return true;
			}else{
				return false;
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public Pedido procurarPedido(String codigo) throws CodigoInexistenteException{
		if(codigo!=null){
			return repositorioPedido.procurar(codigo);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public ArrayList<Pedido> listarPedido(){
		return repositorioPedido.listar();
	}

}
