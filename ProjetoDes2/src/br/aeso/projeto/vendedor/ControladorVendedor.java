package br.aeso.projeto.vendedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaVendedorVaziaException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;

public class ControladorVendedor {
	
	private IRepositorioVendedor repositorioVendedor;
	
	public ControladorVendedor(){
		repositorioVendedor = new RepositorioVendedorArray();
	}
	
	public void cadastrarVendedor(Vendedor vendedor) throws VendedorNaoEncontradoException{
		if(vendedor.getCodigoVendedor()!=null){
			repositorioVendedor.cadastrar(vendedor);
		}else{
			throw new VendedorNaoEncontradoException();
		}
	}
	
	public void atualizarVendedor(Vendedor vendedor) throws CodigoInexistenteException{
		if(vendedor.getCodigoVendedor()!=null){
			repositorioVendedor.atualizar(vendedor);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public boolean removerVendedor(String codigo) throws CodigoInexistenteException{
		if(codigo!=null){
			if(repositorioVendedor.existe(codigo)){
				repositorioVendedor.remover(repositorioVendedor.procurar(codigo));
				return true;
			}else{
				return false;
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public Vendedor procurarVendedor(String codigo) throws CodigoInexistenteException{
		if(codigo!=null){
			return repositorioVendedor.procurar(codigo);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public ArrayList<Vendedor> listarVendedor(){
		return repositorioVendedor.listar();
	}
	
}
