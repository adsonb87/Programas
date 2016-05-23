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
		repositorioCliente.cadastrar(cliente);
	}
	
	public void atualizarCliente (Cliente cliente) throws CodigoInexistenteException{
		repositorioCliente.atualizar(cliente);
	}
	
	public boolean removerCliente (String codigo) throws ClienteNaoEncontradoException, CodigoInexistenteException{
		if(repositorioCliente.existe(codigo)){
			repositorioCliente.remover(repositorioCliente.procurar(codigo));
			return true;
		}else{
			return false;
		}
	}
	
	public Cliente procurarCliente (String codigo) throws CodigoInexistenteException{
		return repositorioCliente.procurar(codigo);
	}
	
	public ArrayList<Cliente> listarCliente() throws ListaClienteVaziaException{
		return repositorioCliente.listar();
	}
	
}
