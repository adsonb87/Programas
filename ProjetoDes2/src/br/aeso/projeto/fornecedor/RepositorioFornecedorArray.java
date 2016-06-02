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
	public void cadastrar(Fornecedor fornecedor){
		if(!existe(fornecedor.getCodigoFornecedor())){
			listaFornecedor.add(fornecedor);
		}
	}

	@Override
	public void atualizar(Fornecedor fornecedor){
		if(existe(fornecedor.getCodigoFornecedor())){
			for(int i=0;i<listaFornecedor.size();i++){
				if(listaFornecedor.get(i).getCodigoFornecedor().equals(fornecedor.getCodigoFornecedor())){
					listaFornecedor.get(i).setCodigoFornecedor(fornecedor.getCodigoFornecedor());
					listaFornecedor.get(i).setNome(fornecedor.getNome());
					listaFornecedor.get(i).setEndereco(fornecedor.getEndereco());
					listaFornecedor.get(i).setTelefone(fornecedor.getTelefone());
				}
			}
		}
	}

	@Override
	public boolean remover(Fornecedor fornecedor){
		if(existe(fornecedor.getCodigoFornecedor())){
			listaFornecedor.remove(fornecedor);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Fornecedor procurar(String codigo){
		if(existe(codigo)){
			for(int i=0; i<listaFornecedor.size(); i++){
				if(listaFornecedor.get(i).getCodigoFornecedor().equals(codigo)){
					return listaFornecedor.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(String codigo){
		if(codigo != null){
			for(int i=0; i<listaFornecedor.size(); i++){
				if(listaFornecedor.get(i).getCodigoFornecedor().equals(codigo)){
					return true;
				}
			}
		}
		return false;		
	}

	@Override
	public ArrayList<Fornecedor> listar(){
		return listaFornecedor;
		
	}

}
