package br.aeso.projeto.fornecedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;
import br.aeso.projeto.util.ListaFornecedorVaziaException;

public class RepositorioFornecedorArray implements IRepositorioFornecedor{
	
	private ArrayList<Fornecedor> listaFornecedor;
	
	public RepositorioFornecedorArray() {
		listaFornecedor = new ArrayList<Fornecedor>();
	}
	
	
	@Override	
	public void cadastrar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		if(fornecedor.getCodigoFornecedor() != null){
			listaFornecedor.add(fornecedor);
		}else{
			throw new FornecedorNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Fornecedor fornecedor)throws CodigoInexistenteException {
		if(fornecedor.getCodigoFornecedor() != null){
			for(int i=0;i<listaFornecedor.size();i++){
				if(listaFornecedor.get(i).getCodigoFornecedor().equals(fornecedor.getCodigoFornecedor())){
					listaFornecedor.get(i).setCodigoFornecedor(fornecedor.getCodigoFornecedor());
					listaFornecedor.get(i).setNome(fornecedor.getNome());
					listaFornecedor.get(i).setEndereco(fornecedor.getEndereco());
					listaFornecedor.get(i).setTelefone(fornecedor.getTelefone());
				}
			}
		}else{
			throw new CodigoInexistenteException();
		}
		
	}

	@Override
	public boolean remover(Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		if(fornecedor.getCodigoFornecedor() != null){
			if(listaFornecedor.contains(fornecedor)){
				listaFornecedor.remove(fornecedor);
				return true;
			}else{
				return false;
			}
		}else{
			throw new FornecedorNaoEncontradoException();
		}
	}

	@Override
	public Fornecedor procurar(String codigo) throws CodigoInexistenteException{
		if(codigo != null){
			for(int i=0; i<listaFornecedor.size(); i++){
				if(listaFornecedor.get(i).getCodigoFornecedor().equals(codigo)){
					return listaFornecedor.get(i);
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
			for(int i=0; i<listaFornecedor.size(); i++){
				if(listaFornecedor.get(i).getCodigoFornecedor().equals(codigo)){
					return true;
				}
			}
		return false;
		}else{
			throw new CodigoInexistenteException();		
		}
		
	}

	@Override
	public ArrayList<Fornecedor> listar() throws ListaFornecedorVaziaException{
		if(!listaFornecedor.isEmpty()){
			return listaFornecedor;
		}else{
			throw new ListaFornecedorVaziaException();
		}
	}

}
