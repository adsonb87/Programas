package br.aeso.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.aeso.projeto.util.ListaClienteVaziaException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem cadastrarClienteMN = new JMenuItem("Cadastrar");
		cadastrarClienteMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionarCliente telaAddCliente;
					telaAddCliente = new TelaAdicionarCliente();
					frame.setContentPane(telaAddCliente);
					frame.getContentPane().revalidate();
			}
		});
		mnCliente.add(cadastrarClienteMN);
		
		JMenuItem atualizarClienteMN = new JMenuItem("Atualizar");
		mnCliente.add(atualizarClienteMN);
		
		JMenuItem removerClienteMN = new JMenuItem("Remover");
		mnCliente.add(removerClienteMN);
		
		JMenuItem procurarClienteMN = new JMenuItem("Procurar");
		mnCliente.add(procurarClienteMN);
		
		JMenuItem listarClienteMN = new JMenuItem("Listar");
		listarClienteMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarCliente telaLCliente = new TelaListarCliente();
				frame.setContentPane(telaLCliente);
				frame.getContentPane().revalidate();
				
			}
		});
		mnCliente.add(listarClienteMN);
		
		JMenu mnFornecedor = new JMenu("Fornecedor");
		menuBar.add(mnFornecedor);
		
		JMenuItem cadastrarFornecedorMN = new JMenuItem("Cadastrar");
		mnFornecedor.add(cadastrarFornecedorMN);
		
		JMenuItem atualizarFornecedorMN = new JMenuItem("Atualizar");
		mnFornecedor.add(atualizarFornecedorMN);
		
		JMenuItem removerFornecedorMN = new JMenuItem("Remover");
		mnFornecedor.add(removerFornecedorMN);
		
		JMenuItem procurarFornecedorMN = new JMenuItem("Procurar");
		mnFornecedor.add(procurarFornecedorMN);
		
		JMenuItem listarFornecedorMN = new JMenuItem("Listar");
		mnFornecedor.add(listarFornecedorMN);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		JMenuItem cadastrarProdutoMN = new JMenuItem("Cadastrar");
		mnProduto.add(cadastrarProdutoMN);
		
		JMenuItem atualizarProdutoMN = new JMenuItem("Atualizar");
		mnProduto.add(atualizarProdutoMN);
		
		JMenuItem removerProdutoMN = new JMenuItem("Remover");
		mnProduto.add(removerProdutoMN);
		
		JMenuItem procurarProdutoMN = new JMenuItem("Procurar");
		mnProduto.add(procurarProdutoMN);
		
		JMenuItem listarProdutoMN = new JMenuItem("Listar");
		mnProduto.add(listarProdutoMN);
		
		JMenu mnVendedor = new JMenu("Vendedor");
		menuBar.add(mnVendedor);
		
		JMenuItem cadastrarVendedorMN = new JMenuItem("Cadastrar");
		mnVendedor.add(cadastrarVendedorMN);
		
		JMenuItem atualizarVendedorMN = new JMenuItem("Atualizar");
		mnVendedor.add(atualizarVendedorMN);
		
		JMenuItem removerVendedorMN = new JMenuItem("Remover");
		mnVendedor.add(removerVendedorMN);
		
		JMenuItem procurarVendedorMN = new JMenuItem("Procurar");
		mnVendedor.add(procurarVendedorMN);
		
		JMenuItem listarVendedorMN = new JMenuItem("Listar");
		mnVendedor.add(listarVendedorMN);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem cadastrarPedidoMN = new JMenuItem("Cadastrar");
		mnPedido.add(cadastrarPedidoMN);
		
		JMenuItem atualizarPedidoMN = new JMenuItem("Atualizar");
		mnPedido.add(atualizarPedidoMN);
		
		JMenuItem removerPedidoMN = new JMenuItem("Remover");
		mnPedido.add(removerPedidoMN);
		
		JMenuItem procurarPedidoMN = new JMenuItem("Procurar");
		mnPedido.add(procurarPedidoMN);
		
		JMenuItem listarPedidoMN = new JMenuItem("Listar");
		mnPedido.add(listarPedidoMN);
		
		JMenu mnNotaFiscal = new JMenu("Nota Fiscal");
		menuBar.add(mnNotaFiscal);
		
		JMenuItem cadastrarNFMN = new JMenuItem("Cadastrar");
		mnNotaFiscal.add(cadastrarNFMN);
		
		JMenuItem atualizarNFMN = new JMenuItem("Atualizar");
		mnNotaFiscal.add(atualizarNFMN);
		
		JMenuItem removerNFMN = new JMenuItem("Remover");
		mnNotaFiscal.add(removerNFMN);
		
		JMenuItem procurarNFMN = new JMenuItem("Procurar");
		mnNotaFiscal.add(procurarNFMN);
		
		JMenuItem listarNFMN = new JMenuItem("Listar");
		mnNotaFiscal.add(listarNFMN);
	}

}
