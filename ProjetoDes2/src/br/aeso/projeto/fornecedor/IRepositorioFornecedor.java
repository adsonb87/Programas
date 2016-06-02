package br.aeso.projeto.fornecedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;
import br.aeso.projeto.util.ListaFornecedorVaziaException;

public interface IRepositorioFornecedor {
	
	public void cadastrar (Fornecedor fornecedor);
	public void atualizar (Fornecedor fornecedor);
	public boolean remover (Fornecedor fornecedor);
	public Fornecedor procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<Fornecedor> listar();
}
