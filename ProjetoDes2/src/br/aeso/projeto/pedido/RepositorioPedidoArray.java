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
	public void cadastrar(Pedido pedido){
		if(!existe(pedido.getCodigoPedido())){
			listaPedido.add(pedido);
		}
	}

	@Override
	public void atualizar(Pedido pedido){
		if(existe(pedido.getCodigoPedido())){
			for(int i=0;i<listaPedido.size();i++){
				if(listaPedido.get(i).getCodigoPedido().equals(pedido.getCodigoPedido())){
					listaPedido.set(i, pedido);
				}
			}
		}
	}

	@Override
	public boolean remover(Pedido pedido){
		if(existe(pedido.getCodigoPedido())){
			listaPedido.remove(pedido);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Pedido procurar(String codigo){
		if(existe(codigo)){
			for(int i=0; i<listaPedido.size();i++){
				if(listaPedido.get(i).getCodigoPedido().equals(codigo)){
					return listaPedido.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(String codigo){
		if(codigo != null){
			for(int i=0; i<listaPedido.size();i++){
				if(listaPedido.get(i).getCodigoPedido().equals(codigo)){
					return true;
				}
			}
		}
 		return false;
	}

	@Override
	public ArrayList<Pedido> listar(){
		return listaPedido;
	}

	
}
