package br.aeso.projeto.cliente;

import java.util.ArrayList;

import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public class TesteCliente {

	public static void main(String[] args) {
		
		Cliente cliente;
		RepositorioClienteArray repo = new RepositorioClienteArray();
		ArrayList<Cliente> lista = new ArrayList<>();
		
		cliente = new Cliente("01","Adson Barbosa de Souza", "Rua 25 de Janeiro, 439", "(81)999468642");
		
		try {
			repo.cadastrar(cliente);
		} catch (ClienteNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		
		cliente = new Cliente("02","Gabriel Justino", "Rua 19 de novembro, 329","(81)999787504");
		
		try {
			repo.cadastrar(cliente);
		} catch (ClienteNaoEncontradoException e2) {
			System.out.println(e2.getMessage());
		}
		
		cliente = new Cliente("03","Jose Edson","Av nacional, 400","(81)999787504");
		
		try {
			repo.cadastrar(cliente);
		} catch (ClienteNaoEncontradoException e2) {
			System.out.println(e2.getMessage());
		}
		
		
		try {
			lista = repo.listar();
			System.out.println("Lista: \n"+lista.toString());
		} catch (ListaClienteVaziaException e) {
			System.out.println(e.getMessage());
		}
		
		
//		try {
//			System.out.println("Existe: "+repo.existe(cliente.getCodigoCliente()));
//		} catch (CodigoInexistenteException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			System.out.println("Procurar: "+repo.procurar("03"));
//		} catch (CodigoInexistenteException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			try {
//				System.out.println("Remover: "+repo.remover(repo.procurar("01")));
//			} catch (CodigoInexistenteException e) {
//				System.out.println(e.getMessage());
//			}
//		} catch (ClienteNaoEncontradoException e) {
//			System.out.println(e.getMessage());
//		}
		
		cliente = new Cliente("03","Lucas","Av. nacional","(81)34273460");
		
		try {
			repo.atualizar(cliente);
		} catch (CodigoInexistenteException e1) {
			System.out.println(e1.getMessage());
		}
		
		
		try {
			lista = repo.listar();
			System.out.println("Lista: "+lista.toString());
		} catch (ListaClienteVaziaException e) {
			System.out.println(e.getMessage());
		}
	}

}
