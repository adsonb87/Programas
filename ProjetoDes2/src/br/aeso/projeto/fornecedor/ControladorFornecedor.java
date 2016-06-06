package br.aeso.projeto.fornecedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;

public class ControladorFornecedor {
	
	private IRepositorioFornecedor repositorioFornecedor;
	
	public ControladorFornecedor(){
		repositorioFornecedor = new RepositorioFornecedorArray();
	}
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		if(fornecedor.getCodigoFornecedor() != null){
			repositorioFornecedor.cadastrar(fornecedor);
		}else{
			throw new FornecedorNaoEncontradoException();
		}
	}
	
	public void atualizarFornecedor(Fornecedor fornecedor) throws CodigoInexistenteException{
		if(fornecedor.getCodigoFornecedor() != null){
			repositorioFornecedor.atualizar(fornecedor);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public boolean removerFornecedor(String codigo) throws CodigoInexistenteException{
		if(codigo != null){
			if(repositorioFornecedor.existe(codigo)){
				repositorioFornecedor.remover(repositorioFornecedor.procurar(codigo));
				return true;
			}else{
				return false;
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public Fornecedor procurarFornecedor(String codigo) throws CodigoInexistenteException{
		if(codigo != null){
			return repositorioFornecedor.procurar(codigo);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public ArrayList<Fornecedor> listarFornecedor(){
		return repositorioFornecedor.listar();
	}
	
}
