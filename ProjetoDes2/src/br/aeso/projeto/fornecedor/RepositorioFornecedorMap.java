package br.aeso.projeto.fornecedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;
import br.aeso.projeto.util.ListaFornecedorVaziaException;

public class RepositorioFornecedorMap implements IRepositorioFornecedor{
	
	private Map<String, Fornecedor> listaFornecedor;
		
	public RepositorioFornecedorMap() {
		listaFornecedor = new HashMap<>();
	}
	
	@Override
	public void cadastrar(Fornecedor fornecedor){
		if(!existe(fornecedor.getCodigoFornecedor())){
			listaFornecedor.put(fornecedor.getCodigoFornecedor(), fornecedor);
		}
	}

	@Override
	public void atualizar(Fornecedor fornecedor){
		if(existe(fornecedor.getCodigoFornecedor())){
			if(listaFornecedor.containsKey(fornecedor.getCodigoFornecedor())){
				listaFornecedor.replace(fornecedor.getCodigoFornecedor(), fornecedor);
			}
		}		
	}

	@Override
	public boolean remover(Fornecedor fornecedor){
		if(existe(fornecedor.getCodigoFornecedor())){
			listaFornecedor.remove(fornecedor.getCodigoFornecedor(), fornecedor);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Fornecedor procurar(String codigo){
		if(existe(codigo)){
			return listaFornecedor.get(codigo);
		}else{
			return null;
		}
	}

	@Override
	public boolean existe(String codigo){
		if(codigo != null){
			if(listaFornecedor.containsKey(codigo)){
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Fornecedor> listar(){
		List<Fornecedor> listaAuxiliar = (List) Arrays.asList(listaFornecedor.toString());
		return (ArrayList<Fornecedor>) listaAuxiliar;
	}
}
