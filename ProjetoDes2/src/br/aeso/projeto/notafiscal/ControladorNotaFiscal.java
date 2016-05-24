package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.cliente.IRepositorioCliente;
import br.aeso.projeto.cliente.RepositorioClienteArray;
import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaClienteVaziaException;
import br.aeso.projeto.util.ListaNotaFiscalNaoEncontradaException;
import br.aeso.projeto.util.NotaFiscalNaoEncontradaException;

public class ControladorNotaFiscal {
	
	private	IRepositorioNotaFiscal repositorioNotaFiscal;
	
	public ControladorNotaFiscal(){
		repositorioNotaFiscal = new RepositorioNotaFiscalArray();
	}
	
	public void cadastrarNotaFiscal(NotaFiscal notaFiscal) throws NotaFiscalNaoEncontradaException{
		
		repositorioNotaFiscal.cadastrar(notaFiscal);
	}
	
	public void atualizarNotaFiscal (NotaFiscal notaFiscal) throws CodigoInexistenteException{
		repositorioNotaFiscal.atualizar(notaFiscal);
	}
	
	public boolean removerNotaFiscal (String codigo) throws NotaFiscalNaoEncontradaException, CodigoInexistenteException{
		if(repositorioNotaFiscal.existe(codigo)){
			repositorioNotaFiscal.remover(repositorioNotaFiscal.procurar(codigo));
			return true;
		}else{
			return false;
		}
	}
	
	public NotaFiscal procurarNotaFiscal (String codigo) throws CodigoInexistenteException{
		return repositorioNotaFiscal.procurar(codigo);
	}
	
	public ArrayList<NotaFiscal> listarNotaFiscal() throws ListaNotaFiscalNaoEncontradaException{
		return repositorioNotaFiscal.listar();
	}
}
