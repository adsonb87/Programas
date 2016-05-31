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
	public void cadastrar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		if(fornecedor.getCodigoFornecedor() != null){
			listaFornecedor.put(fornecedor.getCodigoFornecedor(), fornecedor);
		}else{
			throw new FornecedorNaoEncontradoException();
		}
		
	}

	@Override
	public void atualizar(Fornecedor fornecedor) throws CodigoInexistenteException {
		if(fornecedor.getCodigoFornecedor() != null){
			if(listaFornecedor.containsKey(fornecedor.getCodigoFornecedor())){
				listaFornecedor.replace(fornecedor.getCodigoFornecedor(), fornecedor);
//				listaFornecedor.remove(fornecedor.getCodigoFornecedor());
//				listaFornecedor.put(fornecedor.getCodigoFornecedor(), fornecedor);
			}
		}else{
			throw new CodigoInexistenteException();
		}
		
	}

	@Override
	public boolean remover(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		if(fornecedor.getCodigoFornecedor() != null){
			if(listaFornecedor.containsKey(fornecedor.getCodigoFornecedor())){
				listaFornecedor.remove(fornecedor.getCodigoFornecedor(), fornecedor);
				return true;
			}else{
				return false;
			}
		}else{
			throw new FornecedorNaoEncontradoException();
		}
	}

	@Override
	public Fornecedor procurar(String codigo) throws CodigoInexistenteException {
		if(codigo != null){
			if(listaFornecedor.containsKey(codigo)){
				return listaFornecedor.get(codigo);
			}else{
				return null;
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean existe(String codigo) throws CodigoInexistenteException {
		if(codigo != null){
			if(listaFornecedor.containsKey(codigo)){
				return true;
			}else{
				return false;
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public ArrayList<Fornecedor> listar() throws ListaFornecedorVaziaException {
		if(!listaFornecedor.isEmpty()){
			List<Fornecedor> listaAuxiliar = (List) Arrays.asList(listaFornecedor.toString());
			return (ArrayList<Fornecedor>) listaAuxiliar;
		}else{
			throw new ListaFornecedorVaziaException();
		}
	}

}
