package br.aeso.projeto.cliente;

import java.util.ArrayList;

import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public class TesteCliente2 {

	public static void main(String[] args) {
		
		Cliente c;
		ControladorCliente r = new ControladorCliente();
		ArrayList<Cliente> l = new ArrayList<>();
		
		c = new Cliente("01","Adson Barbosa de Souza", "Rua 25 de Janeiro, 439", "(81)999468642");
		
		try {
			r.cadastrarCliente(c);
		} catch (ClienteNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		
		c = new Cliente("02","Gabriel Justino", "Rua 19 de novembro, 329","(81)999787504");
		
		try {
			r.cadastrarCliente(c);
		} catch (ClienteNaoEncontradoException e1) {
			System.out.println(e1.getMessage());
		}
		
		l = r.listarCliente();
		System.out.println("Listar: "+l.toString());
		
//		try {
//			System.out.println("Procurar "+r.procurarCliente("02"));
//		} catch (CodigoInexistenteException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		c = new Cliente("02","Lucas","Av. nacional","(81)34273460");
//		
//		try {
//			r.atualizarCliente(c);
//		} catch (CodigoInexistenteException e) {
//			System.out.println(e.getMessage());
//		}
		
		try {
			System.out.println("Remover: "+r.removerCliente("01"));
		} catch (CodigoInexistenteException e1) {
			System.out.println(e1.getMessage());
		}
		
		l = r.listarCliente();
		System.out.println("Listar: "+l.toString());
		
	}

}
