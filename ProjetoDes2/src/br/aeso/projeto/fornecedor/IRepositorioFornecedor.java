package br.aeso.projeto.fornecedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;
import br.aeso.projeto.util.ListaFornecedorVaziaException;

public interface IRepositorioFornecedor {
	
	public void cadastrar (Fornecedor fornecedor) throws FornecedorNaoEncontradoException;
	public void atualizar (Fornecedor fornecedor) throws CodigoInexistenteException;
	public boolean remover (Fornecedor fornecedor) throws FornecedorNaoEncontradoException;
	public Fornecedor procurar (String codigo) throws CodigoInexistenteException;
	public boolean existe (String codigo) throws CodigoInexistenteException;
	public ArrayList<Fornecedor> listar() throws ListaFornecedorVaziaException;
}
