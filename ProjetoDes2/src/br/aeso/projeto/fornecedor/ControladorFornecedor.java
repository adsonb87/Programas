package br.aeso.projeto.fornecedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;
import br.aeso.projeto.util.ListaFornecedorVaziaException;

public class ControladorFornecedor {
	
	private IRepositorioFornecedor repositorioFornecedor;
	
	public ControladorFornecedor(){
		repositorioFornecedor = new RepositorioFornecedorArray();
	}
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		repositorioFornecedor.cadastrar(fornecedor);
	}
	
	public void atualizarFornecedor(Fornecedor fornecedor) throws CodigoInexistenteException{
		repositorioFornecedor.atualizar(fornecedor);
	}
	
	public boolean removerFornecedor(String codigo) throws CodigoInexistenteException, FornecedorNaoEncontradoException{
		if(repositorioFornecedor.existe(codigo)){
			repositorioFornecedor.remover(repositorioFornecedor.procurar(codigo));
			return true;
		}else{
			return false;
		}
	}
	
	public Fornecedor procurarFornecedor(String codigo) throws CodigoInexistenteException{
		return repositorioFornecedor.procurar(codigo);
	}
	
	public ArrayList<Fornecedor> listarFornecedor() throws ListaFornecedorVaziaException{
		return repositorioFornecedor.listar();
	}
	
}
