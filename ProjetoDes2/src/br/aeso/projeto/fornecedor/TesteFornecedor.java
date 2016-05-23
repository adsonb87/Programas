package br.aeso.projeto.fornecedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;
import br.aeso.projeto.util.ListaFornecedorVaziaException;

public class TesteFornecedor {

	public static void main(String[] args) {
		
		Fornecedor f;
		IRepositorioFornecedor r = new RepositorioFornecedorArray();
		ArrayList<Fornecedor> l = new ArrayList<>();
		
		f = new Fornecedor("01", "Atacadão", "Av. Pe15, 1001", "(81) 34273400");
		
		try {
			r.cadastrar(f);
		} catch (FornecedorNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		
		f = new Fornecedor("02", "Antonio", "Av. Perimetral, 2012", "(81)999282212");
		
		try {
			r.cadastrar(f);
		} catch (FornecedorNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		
		f = new Fornecedor("03", "Baubino", "Rua Surubim, 1100", "(81)33442111");
		
		try {
			r.cadastrar(f);
		} catch (FornecedorNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			l=r.listar();
			System.out.println("Listar:\n"+l.toString());
		} catch (ListaFornecedorVaziaException e) {
			System.out.println(e.getMessage());
		}
		
//		try {
//			System.out.println("Procurar: "+r.procurar("03"));
//		} catch (CodigoInexistenteException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			System.out.println("Existe: "+r.existe("03"));
//		} catch (CodigoInexistenteException e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			System.out.println("Remover: "+r.remover(r.procurar("02")));
//		} catch (FornecedorNaoEncontradoException | CodigoInexistenteException e) {
//			System.out.println(e.getMessage());
//		}
		
		f = new Fornecedor("02", "Adson", "Rua 25 de janeiro", "(81)999468642");
		
		try {
			r.atualizar(f);
		} catch (CodigoInexistenteException e1) {
			System.out.println(e1.getMessage());
		}
		
		try {
			System.out.println("Listar: "+r.listar());
		} catch (ListaFornecedorVaziaException e) {
			System.out.println(e.getMessage());
		}
	}

}
