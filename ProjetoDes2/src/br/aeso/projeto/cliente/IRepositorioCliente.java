package br.aeso.projeto.cliente;

import java.util.ArrayList;

import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public interface IRepositorioCliente {
	
	public void cadastrar (Cliente cliente);
	public void atualizar (Cliente cliente);
	public boolean remover (Cliente cliente);
	public Cliente procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<Cliente> listar();
}
