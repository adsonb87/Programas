package br.aeso.projeto.vendedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaVendedorVaziaException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;

public interface IRepositorioVendedor {
	public void cadastrar (Vendedor vendedor);
	public void atualizar (Vendedor vendedor);
	public boolean remover (Vendedor vendedor);
	public Vendedor procurar (String codigo);
	public boolean existe (String codigo);
	public ArrayList<Vendedor> listar();
}
