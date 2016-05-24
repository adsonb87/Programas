package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaNotaFiscalNaoEncontradaException;
import br.aeso.projeto.util.NotaFiscalNaoEncontradaException;

public class RepositorioNotaFiscalArray implements IRepositorioNotaFiscal{
	
	private ArrayList<NotaFiscal> listaNotaFiscal;
	
	public RepositorioNotaFiscalArray() {
		listaNotaFiscal = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(NotaFiscal notaFiscal)throws  NotaFiscalNaoEncontradaException{
		if(notaFiscal.getCodigoNotaFiscal() != null){
			listaNotaFiscal.add(notaFiscal);
		}else{
			throw new NotaFiscalNaoEncontradaException();
		}
		
	}

	@Override
	public void atualizar(NotaFiscal notaFiscal)throws CodigoInexistenteException {
		if(notaFiscal.getCodigoNotaFiscal() != null){
			for(int i=0; i<listaNotaFiscal.size();i++){
				if(listaNotaFiscal.get(i).getCodigoNotaFiscal().equals(notaFiscal.getCodigoNotaFiscal())){
					listaNotaFiscal.set(i, notaFiscal);
				}
			}
		}else{
			throw new CodigoInexistenteException();
		}
		
	}

	@Override
	public boolean remover(NotaFiscal notaFiscal)throws NotaFiscalNaoEncontradaException {
		if(notaFiscal.getCodigoNotaFiscal() != null){
			if(listaNotaFiscal.contains(notaFiscal)){
				listaNotaFiscal.remove(notaFiscal);
				return true;
			}else{
				return false;
			}
		}else{
			throw new NotaFiscalNaoEncontradaException();
		}
	}

	@Override
	public NotaFiscal procurar(String codigo)throws CodigoInexistenteException{
		if(codigo != null){
			for(int i=0; i<listaNotaFiscal.size();i++){
				if(listaNotaFiscal.get(i).getCodigoNotaFiscal().equals(codigo)){
					return listaNotaFiscal.get(i);
				}
			}
			return null;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public boolean existe(String codigo)throws CodigoInexistenteException{
		if(codigo != null){
			for(int i=0; i<listaNotaFiscal.size();i++){
				if(listaNotaFiscal.get(i).getCodigoNotaFiscal().equals(codigo)){
					return true;
				}
			}
			return false;
		}else{
			throw new CodigoInexistenteException();
		}
	}

	@Override
	public ArrayList<NotaFiscal> listar()throws ListaNotaFiscalNaoEncontradaException {
		if(!listaNotaFiscal.isEmpty()){
			return listaNotaFiscal;
		}else{
			throw new ListaNotaFiscalNaoEncontradaException();
		}
	}

}
