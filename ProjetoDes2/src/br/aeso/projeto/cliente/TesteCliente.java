package br.aeso.projeto.cliente;

import java.util.ArrayList;

import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public class TesteCliente {

	public static void main(String[] args) {
		
		Cliente cliente;
		ControladorCliente repo = new ControladorCliente();
		ArrayList<Cliente> lista = new ArrayList<>();
		
		cliente = new Cliente("01","Adson Barbosa de Souza", "Rua 25 de Janeiro, 439", "(81)999468642");
		
		try {
			repo.cadastrarCliente(cliente);
		} catch (ClienteNaoEncontradoException e5) {
			// TODO Auto-generated catch block
			System.out.println(e5.getMessage());
		}
		
		cliente = new Cliente("02","Gabriel Justino", "Rua 19 de novembro, 329","(81)999787504");
		
		try {
			repo.cadastrarCliente(cliente);
		} catch (ClienteNaoEncontradoException e4) {
			// TODO Auto-generated catch block
			System.out.println(e4.getMessage());
		}
		
		cliente = new Cliente("03","Jose Edson","Av nacional, 400","(81)999787504");
		
		try {
			repo.cadastrarCliente(cliente);
		} catch (ClienteNaoEncontradoException e3) {
			// TODO Auto-generated catch block
			System.out.println(e3.getMessage());
		}
				
		
		System.out.println(repo.listarCliente());
		
		try {
			System.out.println("Procurar: "+repo.procurarCliente("02"));
		} catch (CodigoInexistenteException e2) {
			// TODO Auto-generated catch block
			System.out.println(e2.getMessage());
		}
		
		cliente = new Cliente("03","adelio","Av nacional, 400","(81)999787504");
		try {
			repo.atualizarCliente(cliente);
		} catch (CodigoInexistenteException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
		try {
			System.out.println(repo.removerCliente("01"));
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		System.out.println(repo.listarCliente());
		
		
	}

}
