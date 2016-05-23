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
	public void cadastrar(Vendedor vendedor) throws VendedorNaoEncontradoException{
		if(vendedor.getCodigoVendedor() != null){
			listaVendedor.add(vendedor);
		}else{
			throw new VendedorNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Vendedor vendedor)throws CodigoInexistenteException {
		if(vendedor.getCodigoVendedor() != null){
			for(int i=0;i<listaVendedor.size();i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(vendedor.getCodigoVendedor())){
					listaVendedor.get(i).setCodigoVendedor(vendedor.getCodigoVendedor());
					listaVendedor.get(i).setNome(vendedor.getNome());
					listaVendedor.get(i).setEndereco(vendedor.getEndereco());
					listaVendedor.get(i).setTelefone(vendedor.getTelefone());
				}
			}
		}else{
			throw new CodigoInexistenteException();
		}
		
	}

	@Override
	public boolean remover(Vendedor vendedor)throws VendedorNaoEncontradoException {
		if(vendedor.getCodigoVendedor() != null){
			if(listaVendedor.contains(vendedor)){
				listaVendedor.remove(vendedor);
				return true;
			}else{
				return false;
			}
		}else{
			throw new VendedorNaoEncontradoException();
		}
	}

	@Override
	public Vendedor procurar(String codigo)throws CodigoInexistenteException {
		if(codigo != null){
			for(int i=0; i<listaVendedor.size();i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(codigo)){
					return listaVendedor.get(i);
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
			for(int i=0;i<listaVendedor.size();i++){
				if(listaVendedor.get(i).getCodigoVendedor().equals(codigo)){
					return true;
				}
			}
			return false;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public ArrayList<Vendedor> listar()throws ListaVendedorVaziaException {
		if(!listaVendedor.isEmpty()){
			return listaVendedor;
		}else{
			throw new ListaVendedorVaziaException();
		}
	}

}
