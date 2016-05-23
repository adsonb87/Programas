package br.aeso.projeto.pedido;

import java.util.ArrayList;

import br.aeso.projeto.produto.ControladorProduto;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;
import br.aeso.projeto.vendedor.ControladorVendedor;
import br.aeso.projeto.vendedor.Vendedor;

public class RepositorioPedidoArray implements IRepositorioPedido{
	
	private ArrayList<Pedido> listaPedido;
	
	private double precoTotalPedido;
	private ArrayList<String> listaCodigoProduto;
	private ArrayList<String> listaNomeProduto;
	private ArrayList<Double> listaQuantidadeProduto;
	private ArrayList<Double> listaPrecoProduto;
	private ArrayList<Double> listaPrecoUnitarioProduto;
	
	public RepositorioPedidoArray(){
		listaPedido = new ArrayList<Pedido>();
		listaCodigoProduto = new ArrayList<String>();
		listaNomeProduto = new ArrayList<>();
		listaQuantidadeProduto = new ArrayList<>();
		listaPrecoProduto = new ArrayList<>();
		listaPrecoUnitarioProduto = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(Pedido pedido)throws PedidoNaoEncontradoException{
		if(pedido != null){
			listaPedido.add(pedido);
			listaCodigoProduto.add(pedido.getCodigoProduto());
			listaNomeProduto.add(pedido.getNomeProduto());
			listaQuantidadeProduto.add(pedido.getQuantidadeProduto());
			listaPrecoProduto.add(pedido.getQuantidadeProduto()*pedido.getPrecoProduto());
			listaPrecoUnitarioProduto.add(pedido.getPrecoProduto());
		}else{
			throw new PedidoNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Pedido pedido) throws CodigoInexistenteException{
		if(pedido.getCodigoPedido()!=null){
			for(int i=0;i<listaPedido.size();i++){
				if(listaPedido.get(i).getCodigoPedido().equals(pedido.getCodigoPedido())){
					listaPedido.get(i).setCodigoProduto(pedido.getCodigoProduto());
					listaPedido.get(i).setCodigoVendedor(pedido.getCodigoVendedor());
					listaPedido.get(i).setQuantidadeProduto(pedido.getQuantidadeProduto());
				}
				
			}
		}else{
			throw new CodigoInexistenteException();
		}
		
	}

	@Override
	public boolean remover(Pedido pedido)throws PedidoNaoEncontradoException {
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
	public Pedido procurar(String codigo)throws CodigoInexistenteException {
		if(codigo != null){
			for(int i=0; i<listaPedido.size(); i++){
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
	public boolean existe(String codigo) throws CodigoInexistenteException{
		if(codigo != null){
			for(int i=0;i<listaPedido.size();i++){
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
	public ArrayList<Pedido> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void listarTudo(String codigoPedido)throws CodigoInexistenteException{
		int index = 0;
		if(codigoPedido != null && existe(codigoPedido)){
			System.out.println("Cod Produto Nome Produto Qtd Produto Preco Unt Preco Total\n");
			for(int i=0; i<listaPedido.size(); i++){
				if(listaPedido.get(i).getCodigoPedido().equals(codigoPedido)){
					System.out.println(listaCodigoProduto.get(i) +
							" "+ listaNomeProduto.get(i) +
							" "+ listaQuantidadeProduto.get(i) +
							" "+ listaPrecoUnitarioProduto.get(i) +
							" "+ listaPrecoProduto.get(i)+"\n");
							
							precoTotalPedido = precoTotalPedido + listaPrecoProduto.get(i);
							index = i;
				}
			}
				System.out.println("Total da nota: "+precoTotalPedido);
				System.out.println("Codigo do Pedido: "+listaCodigoProduto.get(index));
				System.out.println("Vendedor: "+listaPedido.get(index).getCodigoVendedor()+" - "+listaPedido.get(index).getNomeVendedor());
		}else{
			throw new CodigoInexistenteException();
		}
		
	}
	
}
