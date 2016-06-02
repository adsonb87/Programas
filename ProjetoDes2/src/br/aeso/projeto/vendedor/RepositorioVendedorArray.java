package br.aeso.projeto.vendedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaProdutoVaziaException;
import br.aeso.projeto.util.ListaVendedorVaziaException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;

public class RepositorioVendedorArray implements IRepositorioVendedor{
	
	private ArrayList<Vendedor> listaVendedor;
	
	public RepositorioVendedorArray() {
		listaVendedor = new ArrayList<Vendedor>();
	}
	
	@Override
	public void cadastrar(Vendedor vendedor){
		if(!existe(vendedor.getCodigoVendedor())){
			listaVendedor.add(vendedor);
		}
	}

	@Override
	public void atualizar(Vendedor vendedor){
		if(existe(vendedor.getCodigoVendedor())){
			for(int i=0;i<listaVendedor.size();i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(vendedor.getCodigoVendedor())){
					listaVendedor.set(i, vendedor);
//					listaVendedor.get(i).setCodigoVendedor(vendedor.getCodigoVendedor());
//					listaVendedor.get(i).setNome(vendedor.getNome());
//					listaVendedor.get(i).setEndereco(vendedor.getEndereco());
//					listaVendedor.get(i).setTelefone(vendedor.getTelefone());
				}
			}
		}
	}

	@Override
	public boolean remover(Vendedor vendedor){
		if(existe(vendedor.getCodigoVendedor())){
			listaVendedor.remove(vendedor);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Vendedor procurar(String codigo){
		if(existe(codigo)){
			for(int i=0; i<listaVendedor.size();i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(codigo)){
					return listaVendedor.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(String codigo){
		if(codigo != null){
			for(int i=0;i<listaVendedor.size();i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(codigo)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Vendedor> listar(){
		return listaVendedor;
	}

}
