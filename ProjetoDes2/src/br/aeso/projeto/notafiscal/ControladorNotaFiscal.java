package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.NotaFiscalNaoEncontradaException;

public class ControladorNotaFiscal {
	
	private	IRepositorioNotaFiscal repositorioNotaFiscal;
	
	public ControladorNotaFiscal(){
		repositorioNotaFiscal = new RepositorioNotaFiscalArray();
	}
	
	public void cadastrarNotaFiscal(NotaFiscal notaFiscal) throws NotaFiscalNaoEncontradaException{
		if(notaFiscal.getCodigoNotaFiscal()!=null){
			repositorioNotaFiscal.cadastrar(notaFiscal);
		}else{
			throw new NotaFiscalNaoEncontradaException();
		}
	}
	
	public void atualizarNotaFiscal (NotaFiscal notaFiscal) throws CodigoInexistenteException{
		if(notaFiscal.getCodigoNotaFiscal()!=null){
			repositorioNotaFiscal.atualizar(notaFiscal);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public boolean removerNotaFiscal (String codigo) throws CodigoInexistenteException{
		if(codigo!=null){
			if(repositorioNotaFiscal.existe(codigo)){
			repositorioNotaFiscal.remover(repositorioNotaFiscal.procurar(codigo));
			return true;
			}else{
				return false;
			}
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public NotaFiscal procurarNotaFiscal (String codigo) throws CodigoInexistenteException{
		if(codigo!=null){
			return repositorioNotaFiscal.procurar(codigo);
		}else{
			throw new CodigoInexistenteException();
		}
	}
	
	public ArrayList<NotaFiscal> listarNotaFiscal(){
		return repositorioNotaFiscal.listar();
	}
}
