package br.aeso.projeto.cliente;

import java.util.ArrayList;

import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public interface IRepositorioCliente {
	
	public void cadastrar (Cliente cliente) throws ClienteNaoEncontradoException;
	public void atualizar (Cliente cliente) throws CodigoInexistenteException;
	public boolean remover (Cliente cliente) throws ClienteNaoEncontradoException;
	public Cliente procurar (String codigo) throws CodigoInexistenteException;
	public boolean existe (String codigo) throws CodigoInexistenteException;
	public ArrayList<Cliente> listar() throws ListaClienteVaziaException;
}
