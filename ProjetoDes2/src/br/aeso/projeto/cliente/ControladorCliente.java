package br.aeso.projeto.cliente;

import java.util.ArrayList;

import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public class ControladorCliente {
	
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente(){
		repositorioCliente = new RepositorioClienteArray();
	}
	
	public void cadastrarCliente(Cliente cliente) throws ClienteNaoEncontradoException{
		if(cliente.getCodigoCliente() != null){
			repositorioCliente.cadastrar(cliente);
		}else{
			throw new ClienteNaoEncontradoException();
		}
	}
	
	public void atualizarCliente (Cliente cliente) throws CodigoInexistenteException{
		if(cliente.getCodigoCliente() != null){
			repositorioCliente.atualizar(cliente);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public boolean removerCliente (String codigo) throws CodigoInexistenteException{
		if(codigo != null){
			if(repositorioCliente.existe(codigo)){
				repositorioCliente.remover(repositorioCliente.procurar(codigo));
				return true;
			}else{
				return false;
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public Cliente procurarCliente (String codigo) throws CodigoInexistenteException{
		if(codigo != null){
			return repositorioCliente.procurar(codigo);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public ArrayList<Cliente> listarCliente(){
		return repositorioCliente.listar();
	}
	
}
