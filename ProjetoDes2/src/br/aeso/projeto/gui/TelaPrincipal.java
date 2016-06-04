package br.aeso.projeto.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.aeso.projeto.gui.cliente.TelaAtualizarCliente;
import br.aeso.projeto.gui.cliente.TelaCadastrarCliente;
import br.aeso.projeto.gui.cliente.TelaListarCliente;
import br.aeso.projeto.gui.cliente.TelaProcurarCliente;
import br.aeso.projeto.gui.cliente.TelaRemoverCliente;
import br.aeso.projeto.gui.fornecedor.TelaAtualizarFornecedor;
import br.aeso.projeto.gui.fornecedor.TelaCadastrarFornecedor;
import br.aeso.projeto.gui.fornecedor.TelaListarFornecedor;
import br.aeso.projeto.gui.fornecedor.TelaProcurarFornecedor;
import br.aeso.projeto.gui.fornecedor.TelaRemoverFornecedor;
import br.aeso.projeto.gui.produto.TelaAtualizarProduto;
import br.aeso.projeto.gui.produto.TelaCadastrarProduto;
import br.aeso.projeto.gui.produto.TelaListarProduto;
import br.aeso.projeto.gui.produto.TelaProcurarProduto;
import br.aeso.projeto.gui.produto.TelaRemoverProduto;
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
		frame.setBounds(100, 100, 720, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem cadastrarClienteMN = new JMenuItem("Cadastrar");
		cadastrarClienteMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarCliente telaAddCliente;
					telaAddCliente = new TelaCadastrarCliente();
					frame.setContentPane(telaAddCliente);
					frame.getContentPane().revalidate();
			}
		});
		mnCliente.add(cadastrarClienteMN);
		
		JMenuItem atualizarClienteMN = new JMenuItem("Atualizar");
		atualizarClienteMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarCliente telaAttCliente = new TelaAtualizarCliente();
				frame.setContentPane(telaAttCliente);
				frame.getContentPane().revalidate();
			}
		});
		mnCliente.add(atualizarClienteMN);
		
		JMenuItem removerClienteMN = new JMenuItem("Remover");
		removerClienteMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverCliente telaRemoverCliente = new TelaRemoverCliente();
				frame.setContentPane(telaRemoverCliente);
				frame.getContentPane().revalidate();
			}
		});
		mnCliente.add(removerClienteMN);
		
		JMenuItem procurarClienteMN = new JMenuItem("Procurar");
		procurarClienteMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProcurarCliente telaPCliente = new TelaProcurarCliente();
				frame.setContentPane(telaPCliente);
				frame.getContentPane().revalidate();
			}
		});
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
		cadastrarFornecedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarFornecedor telaCFornecedor = new TelaCadastrarFornecedor();
				frame.setContentPane(telaCFornecedor);
				frame.getContentPane().revalidate();
			}
		});
		mnFornecedor.add(cadastrarFornecedorMN);
		
		JMenuItem atualizarFornecedorMN = new JMenuItem("Atualizar");
		atualizarFornecedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarFornecedor telaAFornecedor = new TelaAtualizarFornecedor();
				frame.setContentPane(telaAFornecedor);
				frame.getContentPane().revalidate();
			}
		});
		mnFornecedor.add(atualizarFornecedorMN);
		
		JMenuItem removerFornecedorMN = new JMenuItem("Remover");
		removerFornecedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverFornecedor telaRFornecedor = new TelaRemoverFornecedor();
				frame.setContentPane(telaRFornecedor);
				frame.getContentPane().revalidate();
			}
		});
		mnFornecedor.add(removerFornecedorMN);
		
		JMenuItem procurarFornecedorMN = new JMenuItem("Procurar");
		procurarFornecedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarFornecedor telaPFornecedor = new TelaProcurarFornecedor();
				frame.setContentPane(telaPFornecedor);
				frame.getContentPane().revalidate();
			}
		});
		mnFornecedor.add(procurarFornecedorMN);
		
		JMenuItem listarFornecedorMN = new JMenuItem("Listar");
		listarFornecedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarFornecedor telaLFornecedor = new TelaListarFornecedor();
				frame.setContentPane(telaLFornecedor);
				frame.getContentPane().revalidate();
			}
		});
		mnFornecedor.add(listarFornecedorMN);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		JMenuItem cadastrarProdutoMN = new JMenuItem("Cadastrar");
		cadastrarProdutoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarProduto telaCProduto = new TelaCadastrarProduto();
				frame.setContentPane(telaCProduto);
				frame.getContentPane().revalidate();
			}
		});
		mnProduto.add(cadastrarProdutoMN);
		
		JMenuItem atualizarProdutoMN = new JMenuItem("Atualizar");
		atualizarProdutoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarProduto telaAProduto = new TelaAtualizarProduto();
				frame.setContentPane(telaAProduto);
				frame.getContentPane().revalidate();
			}
		});
		mnProduto.add(atualizarProdutoMN);
		
		JMenuItem removerProdutoMN = new JMenuItem("Remover");
		removerProdutoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverProduto telaRProduto = new TelaRemoverProduto();
				frame.setContentPane(telaRProduto);
				frame.getContentPane().revalidate();
			}
		});
		mnProduto.add(removerProdutoMN);
		
		JMenuItem procurarProdutoMN = new JMenuItem("Procurar");
		procurarProdutoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarProduto telaPProduto = new TelaProcurarProduto();
				frame.setContentPane(telaPProduto);
				frame.getContentPane().revalidate();
			}
		});
		mnProduto.add(procurarProdutoMN);
		
		JMenuItem listarProdutoMN = new JMenuItem("Listar");
		listarProdutoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarProduto telaLProduto = new TelaListarProduto();
				frame.setContentPane(telaLProduto);
				frame.getContentPane().revalidate();
			}
		});
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
