package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

public interface IRepositorioNotaFiscal {
	public void cadastrar (NotaFiscal notaFiscal);
	public void atualizar (NotaFiscal notaFiscal);
	public boolean remover (NotaFiscal notaFiscal);
	public NotaFiscal procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<NotaFiscal> listar();
}
