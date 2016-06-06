package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

public class RepositorioNotaFiscalArray implements IRepositorioNotaFiscal{
	
	private ArrayList<NotaFiscal> listaNotaFiscal;
	
	public RepositorioNotaFiscalArray() {
		listaNotaFiscal = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(NotaFiscal notaFiscal){
		if(!existe(notaFiscal.getCodigoNotaFiscal())){
			listaNotaFiscal.add(notaFiscal);
		}
	}

	@Override
	public void atualizar(NotaFiscal notaFiscal){
		if(existe(notaFiscal.getCodigoNotaFiscal())){
			for(int i=0; i<listaNotaFiscal.size();i++){
				if(listaNotaFiscal.get(i).getCodigoNotaFiscal().equals(notaFiscal.getCodigoNotaFiscal())){
					listaNotaFiscal.set(i, notaFiscal);
				}
			}
		}
	}

	@Override
	public boolean remover(NotaFiscal notaFiscal){
		if(existe(notaFiscal.getCodigoNotaFiscal())){
			listaNotaFiscal.remove(notaFiscal);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public NotaFiscal procurar(String codigo){
		if(existe(codigo)){
			for(int i=0; i<listaNotaFiscal.size();i++){
				if(listaNotaFiscal.get(i).getCodigoNotaFiscal().equals(codigo)){
					return listaNotaFiscal.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(String codigo){
		if(codigo != null){
			for(int i=0; i<listaNotaFiscal.size();i++){
				if(listaNotaFiscal.get(i).getCodigoNotaFiscal().equals(codigo)){
					return true;
				}
			}		
		}
		return false;
	}

	@Override
	public ArrayList<NotaFiscal> listar(){
		return listaNotaFiscal;
	}

}
