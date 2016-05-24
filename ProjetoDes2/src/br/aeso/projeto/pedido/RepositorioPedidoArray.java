package br.aeso.projeto.pedido;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaPedidoVaziaException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;

public class RepositorioPedidoArray implements IRepositorioPedido{
	
	private ArrayList<Pedido> listaPedido;
	
	public RepositorioPedidoArray(){
		listaPedido = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(Pedido pedido)throws PedidoNaoEncontradoException {
		if(pedido.getCodigoPedido() != null){
			listaPedido.add(pedido);
		}else{
			throw new PedidoNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Pedido pedido)throws CodigoInexistenteException {
		if(pedido.getCodigoPedido()!=null){
			for(int i=0;i<listaPedido.size();i++){
				if(listaPedido.get(i).getCodigoPedido().equals(pedido.getCodigoPedido())){
					listaPedido.set(i, pedido);
				}
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean remover(Pedido pedido) throws PedidoNaoEncontradoException{
		if(pedido.getCodigoPedido() != null){
			if(listaPedido.contains(pedido)){
				listaPedido.remove(pedido);
				return true;
			}else{
				return false;
			}
		}else{
			throw new PedidoNaoEncontradoException();
		}
	}

	@Override
	public Pedido procurar(String codigo)throws CodigoInexistenteException{
		if(codigo != null){
			for(int i=0; i<listaPedido.size();i++){
				if(listaPedido.get(i).getCodigoPedido().equals(codigo)){
					return listaPedido.get(i);
				}
			}
			return null;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean existe(String codigo)throws CodigoInexistenteException{
		if(codigo != null){
			for(int i=0; i<listaPedido.size();i++){
				if(listaPedido.get(i).getCodigoPedido().equals(codigo)){
					return true;
				}
			}
			return false;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public ArrayList<Pedido> listar()throws ListaPedidoVaziaException {
		if(!listaPedido.isEmpty()){
			return listaPedido;
		}else{
			throw new ListaPedidoVaziaException();
		}
	}

	
}
