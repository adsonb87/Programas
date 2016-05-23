package br.aeso.projeto.vendedor;

import java.util.ArrayList;

import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.ListaVendedorVaziaException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;

public interface IRepositorioVendedor {
	public void cadastrar (Vendedor vendedor) throws VendedorNaoEncontradoException;
	public void atualizar (Vendedor vendedor) throws CodigoInexistenteException;
	public boolean remover (Vendedor vendedor) throws VendedorNaoEncontradoException;
	public Vendedor procurar (String codigo) throws CodigoInexistenteException;
	public boolean existe (String codigo) throws CodigoInexistenteException;
	public ArrayList<Vendedor> listar() throws ListaVendedorVaziaException;
}
