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
		
		r.cadastrar(f);
		
		f = new Fornecedor("02", "Antonio", "Av. Perimetral, 2012", "(81)999282212");
		
		r.cadastrar(f);
		
		f = new Fornecedor("03", "Baubino", "Rua Surubim, 1100", "(81)33442111");
		
		r.cadastrar(f);
		
		l=r.listar();
		System.out.println("Listar:\n"+l.toString());
		
		System.out.println("Procurar: "+r.procurar("03"));
				
		System.out.println("Remover: "+r.remover(r.procurar("02")));
		
		f = new Fornecedor("02", "Adson", "Rua 25 de janeiro", "(81)999468642");
		
		r.atualizar(f);
		
		System.out.println("Listar: "+r.listar());
	}

}
