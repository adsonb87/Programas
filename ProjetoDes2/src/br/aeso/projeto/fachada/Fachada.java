package br.aeso.projeto.fachada;

import java.util.ArrayList;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.cliente.ControladorCliente;
import br.aeso.projeto.fornecedor.ControladorFornecedor;
import br.aeso.projeto.fornecedor.Fornecedor;
import br.aeso.projeto.pedido.ControladorPedido;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.produto.ControladorProduto;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;
import br.aeso.projeto.util.ListaClienteVaziaException;
import br.aeso.projeto.util.ListaFornecedorVaziaException;
import br.aeso.projeto.util.ListaProdutoVaziaException;
import br.aeso.projeto.util.ListaVendedorVaziaException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;
import br.aeso.projeto.util.VendedorNaoEncontradoException;
import br.aeso.projeto.vendedor.ControladorVendedor;
import br.aeso.projeto.vendedor.Vendedor;

public class Fachada {
	
	private ControladorProduto controladorProduto;
	private ControladorVendedor controladorVendedor;
	private ControladorCliente controladorCliente;
	private ControladorFornecedor controladorFornecedor;
	private ControladorPedido controladorPedido;
	
	public Fachada(){
		controladorCliente = new ControladorCliente();
		controladorVendedor = new ControladorVendedor();
		controladorProduto = new ControladorProduto();
		controladorFornecedor = new ControladorFornecedor();
		controladorPedido = new ControladorPedido();
	}
	
	//Bloco de Cliente
	public void cadastrarCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		controladorCliente.cadastrarCliente(cliente);
	}
	public void atualizarCliente (Cliente cliente) throws CodigoInexistenteException {
		controladorCliente.atualizarCliente(cliente);
	}
	public boolean removerCliente (String codigo) throws ClienteNaoEncontradoException, CodigoInexistenteException {
		if(codigo != null){
			controladorCliente.removerCliente(codigo);
			return true;
		}else{
			return false;
		}
	}
	public Cliente procurarCliente (String codigo) throws CodigoInexistenteException {
		return controladorCliente.procurarCliente(codigo);
	}
	
	public ArrayList<Cliente> listarCliente() throws ListaClienteVaziaException{
		return controladorCliente.listarCliente();
	}
	
	//Bloco de Fornecedor
	public void cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		controladorFornecedor.cadastrarFornecedor(fornecedor);
	}
	
	public void atualizarFornecedor(Fornecedor fornecedor) throws CodigoInexistenteException{
		controladorFornecedor.atualizarFornecedor(fornecedor);
	}
	
	public boolean removerFornecedor(String codigo) throws CodigoInexistenteException, FornecedorNaoEncontradoException{
		if(codigo != null){
			controladorFornecedor.removerFornecedor(codigo);
			return true;
		}else{
			return false;
		}
	}
	
	public Fornecedor procurarFornecedor(String codigo) throws CodigoInexistenteException{
		return controladorFornecedor.procurarFornecedor(codigo);
	}
	
	public ArrayList<Fornecedor> listarFornecedor() throws ListaFornecedorVaziaException{
		return controladorFornecedor.listarFornecedor();
	}
	
	//Bloco de Produto
	public void cadastrarProduto(Produto produto) throws ProdutoNaoEncontradoException{
		controladorProduto.cadastrarProduto(produto);
	}
	
	public void atualizarProduto(Produto produto) throws CodigoInexistenteException{
		controladorProduto.atualizarProduto(produto);
	}
	
	public boolean removerProduto(String codigo) throws CodigoInexistenteException, ProdutoNaoEncontradoException{
		if(codigo != null){
			controladorProduto.removerProduto(codigo);
			return true;
		}else{
			return false;
		}
	}
	
	public Produto procurarProduto(String codigo) throws CodigoInexistenteException{
		return controladorProduto.procurarProduto(codigo);
	}
	
	public ArrayList<Produto> listarProduto() throws ListaProdutoVaziaException{
		return controladorProduto.listarProduto();
	}
	
	//Bloco de Vendedor
	public void cadastrarVendedor(Vendedor vendedor) throws VendedorNaoEncontradoException{
		controladorVendedor.cadastrarVendedor(vendedor);
	}
	
	public void atualizarVendedor(Vendedor vendedor) throws CodigoInexistenteException{
		controladorVendedor.atualizarVendedor(vendedor);
	}
	
	public boolean removerVendedor(String codigo) throws VendedorNaoEncontradoException, CodigoInexistenteException{
		if( codigo != null){
			controladorVendedor.removerVendedor(codigo);
			return true;
		}else{
			return false;
		}
	}
	
	public Vendedor procurarVendedor(String codigo) throws CodigoInexistenteException{
		return controladorVendedor.procurarVendedor(codigo);
	}
	
	public ArrayList<Vendedor> listarVendedor() throws ListaVendedorVaziaException{
		return controladorVendedor.listarVendedor();
	}
	
	//Bloco de Pedido
	public void cadastrarPedido(Pedido pedido) throws PedidoNaoEncontradoException{
		controladorPedido.cadastrarPedido(pedido);
	}
	
	public void atualizarPedido(Pedido pedido) throws CodigoInexistenteException{
		controladorPedido.atualizarPedido(pedido);
	}
	
	public boolean removerPedido(String codigo) throws CodigoInexistenteException, PedidoNaoEncontradoException{
		if(codigo != null){
			controladorPedido.removerPedido(codigo);
			return true;
		}else{
			return false;
		}
	}
	
	public Pedido procurarPedido(String codigo) throws CodigoInexistenteException{
		return controladorPedido.procurarPedido(codigo);
	}
	
	public void listarPedido(String codigo) throws CodigoInexistenteException{
		controladorPedido.listarPedido(codigo);
	}
	
}
