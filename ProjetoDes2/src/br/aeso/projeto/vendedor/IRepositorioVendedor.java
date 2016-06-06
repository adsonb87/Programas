package br.aeso.projeto.vendedor;

import java.util.ArrayList;

public interface IRepositorioVendedor {
	public void cadastrar (Vendedor vendedor);
	public void atualizar (Vendedor vendedor);
	public boolean remover (Vendedor vendedor);
	public Vendedor procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<Vendedor> listar();
}
