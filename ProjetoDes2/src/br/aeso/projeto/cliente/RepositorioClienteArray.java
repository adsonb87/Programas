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
	public void cadastrar(Cliente cliente){
		if(!existe(cliente.getCodigoCliente())){
			listaCliente.add(cliente);
		}
	}

	@Override
	public void atualizar(Cliente cliente){
		if(existe(cliente.getCodigoCliente())){
			for(int i=0; i<listaCliente.size();i++){
				if(listaCliente.get(i).getCodigoCliente().equals(cliente.getCodigoCliente())){
					listaCliente.set(i, cliente);
//					listaCliente.get(i).setCodigoCliente(cliente.getCodigoCliente());
//					listaCliente.get(i).setNome(cliente.getNome());
//					listaCliente.get(i).setEndereco(cliente.getEndereco());
//					listaCliente.get(i).setTelefone(cliente.getTelefone());
				}
			}
		}
	}

	@Override
	public boolean remover(Cliente cliente){
		if(existe(cliente.getCodigoCliente())){
			listaCliente.remove(cliente);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Cliente procurar(String codigo){
		if(existe(codigo)){
			for(int i=0; i<listaCliente.size();i++){
				if(listaCliente.get(i).getCodigoCliente().equals(codigo)){
					return listaCliente.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(String codigo){
		if(codigo != null){
			for(int i=0;i<listaCliente.size();i++){
				if(listaCliente.get(i).getCodigoCliente().equals(codigo)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Cliente> listar(){
		return listaCliente;
	}
	

}
