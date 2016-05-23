package br.aeso.projeto.cliente;

import java.util.ArrayList;

import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public class RepositorioClienteArray implements IRepositorioCliente{
	
	private ArrayList<Cliente> listaCliente;
	
	public RepositorioClienteArray() {
		listaCliente = new ArrayList<Cliente>();
	}
	
	@Override
	public void cadastrar(Cliente cliente)throws ClienteNaoEncontradoException {
		if(cliente.getCodigoCliente() != null){
			listaCliente.add(cliente);
		}else{
			throw new ClienteNaoEncontradoException();
		}
	}

	@Override
	public void atualizar(Cliente cliente)throws CodigoInexistenteException{
		if(cliente.getCodigoCliente() != null){
			for(int i=0; i<listaCliente.size();i++){
				if(listaCliente.get(i).getCodigoCliente().equals(cliente.getCodigoCliente())){
					listaCliente.get(i).setCodigoCliente(cliente.getCodigoCliente());
					listaCliente.get(i).setNome(cliente.getNome());
					listaCliente.get(i).setEndereco(cliente.getEndereco());
					listaCliente.get(i).setTelefone(cliente.getTelefone());
				}
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean remover(Cliente cliente)throws ClienteNaoEncontradoException {
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
	public Cliente procurar(String codigo)throws CodigoInexistenteException {
		if(codigo != null){
			for(int i=0; i<listaCliente.size();i++){
				if(listaCliente.get(i).getCodigoCliente().equals(codigo)){
					return listaCliente.get(i);
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
			for(int i=0;i<listaCliente.size();i++){
				if(listaCliente.get(i).getCodigoCliente().equals(codigo)){
					return true;
				}
			}
			return false;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public ArrayList<Cliente> listar() throws ListaClienteVaziaException{
		if(!listaCliente.isEmpty()){
			return listaCliente;
		}else{
			throw new ListaClienteVaziaException();
		}
	}
	

}
