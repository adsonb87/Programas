package br.aeso.projeto.fornecedor;

import java.util.ArrayList;

public interface IRepositorioFornecedor {
	
	public void cadastrar (Fornecedor fornecedor);
	public void atualizar (Fornecedor fornecedor);
	public boolean remover (Fornecedor fornecedor);
	public Fornecedor procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<Fornecedor> listar();
}
