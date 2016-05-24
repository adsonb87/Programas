package br.aeso.projeto.notafiscal;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaNotaFiscalNaoEncontradaException;
import br.aeso.projeto.util.NotaFiscalNaoEncontradaException;

public interface IRepositorioNotaFiscal {
	public void cadastrar (NotaFiscal notaFiscal) throws NotaFiscalNaoEncontradaException;
	public void atualizar (NotaFiscal notaFiscal) throws CodigoInexistenteException;
	public boolean remover (NotaFiscal notaFiscal) throws NotaFiscalNaoEncontradaException;
	public NotaFiscal procurar (String codigo) throws CodigoInexistenteException;
	public boolean existe (String codigo) throws CodigoInexistenteException;
	public ArrayList<NotaFiscal> listar() throws ListaNotaFiscalNaoEncontradaException;
}
