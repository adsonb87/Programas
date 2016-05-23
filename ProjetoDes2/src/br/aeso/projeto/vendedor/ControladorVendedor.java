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
		repositorioVendedor.cadastrar(vendedor);
	}
	
	public void atualizarVendedor(Vendedor vendedor) throws CodigoInexistenteException{
		repositorioVendedor.atualizar(vendedor);
	}
	
	public boolean removerVendedor(String codigo) throws VendedorNaoEncontradoException, CodigoInexistenteException{
		if(repositorioVendedor.existe(codigo)){
			repositorioVendedor.remover(repositorioVendedor.procurar(codigo));
			return true;
		}else{
			return false;
		}
	}
	
	public Vendedor procurarVendedor(String codigo) throws CodigoInexistenteException{
		return repositorioVendedor.procurar(codigo);
	}
	
	public ArrayList<Vendedor> listarVendedor() throws ListaVendedorVaziaException{
		return repositorioVendedor.listar();
	}
	
}
