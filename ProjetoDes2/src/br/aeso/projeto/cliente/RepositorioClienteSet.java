package br.aeso.projeto.cliente;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositorioClienteSet implements IRepositorioCliente{

	Set<Cliente> listaCliente;
	
	public RepositorioClienteSet() {
		listaCliente = new HashSet<>();
	}
	
		
	@Override
	public void cadastrar(Cliente cliente){
		if(!existe(cliente.getCodigoCliente())){
			listaCliente.add(cliente);
		}
	}

	@Override
	public void atualizar(Cliente cliente){
		if (existe(cliente.getCodigoCliente())){
			List<Cliente> listaAuxiliar = new ArrayList<>(listaCliente);
			for(int i=0; i<listaAuxiliar.size();i++){
				if(listaAuxiliar.get(i).getCodigoCliente().equals(cliente.getCodigoCliente())){
					listaAuxiliar.set(i, cliente);
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
	public Cliente procurar(String codigo) {
		if(existe(codigo)){
			List<Cliente> listaAuxiliar = new ArrayList<>(listaCliente);
			for(int i=0; i<listaAuxiliar.size();i++){
				if(listaAuxiliar.get(i).getCodigoCliente().equals(codigo)){
					return listaAuxiliar.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(String codigo){
		if(codigo != null){
			List<Cliente> listaAuxiliar = new ArrayList<>(listaCliente);
			for(int i=0;i<listaAuxiliar.size();i++){
				if(listaAuxiliar.get(i).getCodigoCliente().equals(codigo)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> listaAuxiliar = new ArrayList<>(listaCliente);
		return listaAuxiliar;
		
	}

}
