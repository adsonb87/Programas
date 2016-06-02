package br.aeso.projeto.vendedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaVendedorVaziaException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;

public class TesteVendedorArquivo {

	public static void main(String[] args) {
		
		Vendedor vendedor;
		IRepositorioVendedor repositorio = new RepositorioVendedorArquivo();
		
		vendedor = new Vendedor("03", "Adson", "endereco", "telefone");
		
//		repositorio.cadastrar(vendedor);
		
		repositorio.remover(repositorio.procurar("03"));
		
		System.out.println(repositorio.listar());
		
		
	}

}
