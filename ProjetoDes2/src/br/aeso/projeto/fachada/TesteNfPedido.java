package br.aeso.projeto.fachada;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.notafiscal.NotaFiscal;
import br.aeso.projeto.notafiscal.RepositorioNotaFiscalArray;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.pedido.RepositorioPedidoArray;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.produto.RepositorioProdutoArray;
import br.aeso.projeto.vendedor.Vendedor;

public class TesteNfPedido {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("01", "Adson", "endereco", "telefone");
		Vendedor vendedor = new Vendedor("01", "Ozeias", "endereco", "telefone");
		Produto produto;
		Pedido pedido;
		NotaFiscal nf;
		
		RepositorioProdutoArray rProduto = new RepositorioProdutoArray();
		RepositorioNotaFiscalArray rNota = new RepositorioNotaFiscalArray();
		RepositorioPedidoArray rPedido = new RepositorioPedidoArray();
		
		produto = new Produto("01", "nome", 2, "dataVencimento");
		rProduto.cadastrar(produto);
		produto = new Produto("02", "nome", 3, "dataVencimento");
		rProduto.cadastrar(produto);
		produto = new Produto("03", "nome", 4, "dataVencimento");
		rProduto.cadastrar(produto);
		
		nf = new NotaFiscal("1", cliente, vendedor);
		rNota.cadastrar(nf);
		
		nf = new NotaFiscal("2", cliente, vendedor);
		rNota.cadastrar(nf);
		
		pedido = new Pedido(rNota.procurar("1"), "1", rProduto.procurar("01"), 10);
		rNota.procurar("1").adicionarPedido(pedido);
		rPedido.cadastrar(pedido);
		
		pedido = new Pedido(rNota.procurar("1"), "2", rProduto.procurar("02"), 10);
		rNota.procurar("1").adicionarPedido(pedido);
		rPedido.cadastrar(pedido);
		
		System.out.println(rNota.procurar("1").toString());
		
		int cont=0;
		
		for(int i=0; i<rNota.listar().size();i++){
			
			if(rNota.listar().get(i).getCliente().getCodigoCliente().equals("01")){
				cont++;
			}
		}
		 	cont++;
		
		String a = Integer.toString(cont);

		
		System.out.println("GErador: "+rNota.procurar("1").getCliente().getCodigoCliente().concat(a));
		
		
		
		
					
		
		
		

	}

}
