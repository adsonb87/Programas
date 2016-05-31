package br.aeso.projeto.vendedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaVendedorVaziaException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;

public class TesteVendedorArquivo {

	public static void main(String[] args) {
		
		Vendedor vendedor;
		IRepositorioVendedor repositorio = new RepositorioVendedorArquivo();
		
		vendedor = new Vendedor("01", "Adson", "endereco", "telefone");
		
		try {
			repositorio.cadastrar(vendedor);
		} catch (VendedorNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		vendedor = new Vendedor("02", "Pita", "endereco", "telefone");
		
		try {
			repositorio.cadastrar(vendedor);
		} catch (VendedorNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		try {
//			System.out.println("Procurar: "+repositorio.procurar("02").toString());
//		} catch (CodigoInexistenteException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
//		try {
//			ArrayList<Vendedor> lista = repositorio.listar();
//			System.out.println("Listar: "+lista.toString());
//		} catch (ListaVendedorVaziaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println("Remover: "+repositorio.remover(repositorio.procurar("01")));
//		} catch (VendedorNaoEncontradoException | CodigoInexistenteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		

		
		vendedor = new Vendedor("02", "Adelio", "endereco", "telefone");
		
		try {
			repositorio.atualizar(vendedor);
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<Vendedor> lista = repositorio.listar();
			System.out.println("Listar: "+lista.toString());
		} catch (ListaVendedorVaziaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
