package br.aeso.projeto.cliente;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public class RepositorioClienteSet implements IRepositorioCliente{

	Set<Cliente> listaCliente;
	
	public RepositorioClienteSet() {
		listaCliente = new HashSet<>();
	}
	
		
	@Override
	public void cadastrar(Cliente cliente) throws ClienteNaoEncontradoException {
		if(cliente.getCodigoCliente() != null){
			listaCliente.add(cliente);
		}else{
			throw new ClienteNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws CodigoInexistenteException {
		if (cliente.getCodigoCliente() != null){
			List<Cliente> listaAuxiliar = new ArrayList<>(listaCliente);
			for(int i=0; i<listaAuxiliar.size();i++){
				if(listaAuxiliar.get(i).getCodigoCliente().equals(cliente.getCodigoCliente())){
					listaAuxiliar.set(i, cliente);
				}
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean remover(Cliente cliente) throws ClienteNaoEncontradoException {
		if(cliente.getCodigoCliente() != null){
			if(listaCliente.contains(cliente)){
				listaCliente.remove(cliente);
				return true;
			}else{
				return false;
			}
		}else{
			throw new ClienteNaoEncontradoException();
		}
	}

	@Override
	public Cliente procurar(String codigo) throws CodigoInexistenteException {
		if(codigo != null){
			List<Cliente> listaAuxiliar = new ArrayList<>(listaCliente);
			for(int i=0; i<listaAuxiliar.size();i++){
				if(listaAuxiliar.get(i).getCodigoCliente().equals(codigo)){
					return listaAuxiliar.get(i);
				}
			}
			return null;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean existe(String codigo) throws CodigoInexistenteException {
		if(codigo != null){
			List<Cliente> listaAuxiliar = new ArrayList<>(listaCliente);
			for(int i=0;i<listaAuxiliar.size();i++){
				if(listaAuxiliar.get(i).getCodigoCliente().equals(codigo)){
					return true;
				}
			}
			return false;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public ArrayList<Cliente> listar() throws ListaClienteVaziaException {
		if(!listaCliente.isEmpty()){
			ArrayList<Cliente> listaAuxiliar = new ArrayList<>(listaCliente);
			return listaAuxiliar;
		}else{
			throw new ListaClienteVaziaException();
		}
	}

}
