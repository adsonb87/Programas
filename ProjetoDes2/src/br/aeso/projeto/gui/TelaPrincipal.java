package br.aeso.projeto.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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
import br.aeso.projeto.gui.notafiscal.TelaAtualizarNota;
import br.aeso.projeto.gui.notafiscal.TelaCadastrarNota;
import br.aeso.projeto.gui.notafiscal.TelaListarNota;
import br.aeso.projeto.gui.notafiscal.TelaProcurarNota;
import br.aeso.projeto.gui.notafiscal.TelaRemoverNota;
import br.aeso.projeto.gui.pedido.TelaAtualizarPedido;
import br.aeso.projeto.gui.pedido.TelaCadastrarPedido;
import br.aeso.projeto.gui.pedido.TelaListarPedido;
import br.aeso.projeto.gui.pedido.TelaProcurarPedido;
import br.aeso.projeto.gui.pedido.TelaRemoverPedido;
import br.aeso.projeto.gui.produto.TelaAtualizarProduto;
import br.aeso.projeto.gui.produto.TelaCadastrarProduto;
import br.aeso.projeto.gui.produto.TelaListarProduto;
import br.aeso.projeto.gui.produto.TelaProcurarProduto;
import br.aeso.projeto.gui.produto.TelaRemoverProduto;
import br.aeso.projeto.gui.vendedor.TelaAtualizarVendedor;
import br.aeso.projeto.gui.vendedor.TelaCadastrarVendedor;
import br.aeso.projeto.gui.vendedor.TelaListarVendedor;
import br.aeso.projeto.gui.vendedor.TelaProcurarVendedor;
import br.aeso.projeto.gui.vendedor.TelaRemoverVendedor;

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
		cadastrarVendedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarVendedor telaCVendedor = new TelaCadastrarVendedor();
				frame.setContentPane(telaCVendedor);
				frame.getContentPane().revalidate();
			}
		});
		mnVendedor.add(cadastrarVendedorMN);
		
		JMenuItem atualizarVendedorMN = new JMenuItem("Atualizar");
		atualizarVendedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarVendedor telaAVendedor = new TelaAtualizarVendedor();
				frame.setContentPane(telaAVendedor);
				frame.getContentPane().revalidate();
			}
		});
		mnVendedor.add(atualizarVendedorMN);
		
		JMenuItem removerVendedorMN = new JMenuItem("Remover");
		removerVendedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverVendedor telaRVendedor = new TelaRemoverVendedor();
				frame.setContentPane(telaRVendedor);
				frame.getContentPane().revalidate();
			}
		});
		mnVendedor.add(removerVendedorMN);
		
		JMenuItem procurarVendedorMN = new JMenuItem("Procurar");
		procurarVendedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarVendedor telaPVendedor = new TelaProcurarVendedor();
				frame.setContentPane(telaPVendedor);
				frame.getContentPane().revalidate();
			}
		});
		mnVendedor.add(procurarVendedorMN);
		
		JMenuItem listarVendedorMN = new JMenuItem("Listar");
		listarVendedorMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarVendedor telaLVendedor = new TelaListarVendedor();
				frame.setContentPane(telaLVendedor);
				frame.getContentPane().revalidate();		
			}
		});
		mnVendedor.add(listarVendedorMN);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem cadastrarPedidoMN = new JMenuItem("Cadastrar");
		cadastrarPedidoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarPedido telaCPedido = new TelaCadastrarPedido();
				frame.setContentPane(telaCPedido);
				frame.getContentPane().revalidate();
			}
		});
		mnPedido.add(cadastrarPedidoMN);
		
		JMenuItem atualizarPedidoMN = new JMenuItem("Atualizar");
		atualizarPedidoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarPedido telaAPedido = new TelaAtualizarPedido();
				frame.setContentPane(telaAPedido);
				frame.getContentPane().revalidate();
			}
		});
		mnPedido.add(atualizarPedidoMN);
		
		JMenuItem removerPedidoMN = new JMenuItem("Remover");
		removerPedidoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverPedido telaRPedido = new TelaRemoverPedido();
				frame.setContentPane(telaRPedido);
				frame.getContentPane().revalidate();
			}
		});
		mnPedido.add(removerPedidoMN);
		
		JMenuItem procurarPedidoMN = new JMenuItem("Procurar");
		procurarPedidoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarPedido telaPPedido = new TelaProcurarPedido();
				frame.setContentPane(telaPPedido);
				frame.getContentPane().revalidate();
			}
		});
		mnPedido.add(procurarPedidoMN);
		
		JMenuItem listarPedidoMN = new JMenuItem("Listar");
		listarPedidoMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarPedido telaLPedido = new TelaListarPedido();
				frame.setContentPane(telaLPedido);
				frame.getContentPane().revalidate();
			}
		});
		mnPedido.add(listarPedidoMN);
		
		JMenu mnNotaFiscal = new JMenu("Nota Fiscal");
		menuBar.add(mnNotaFiscal);
		
		JMenuItem cadastrarNFMN = new JMenuItem("Cadastrar");
		cadastrarNFMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarNota telaCNota = new TelaCadastrarNota();
				frame.setContentPane(telaCNota);
				frame.getContentPane().revalidate();
			}
		});
		mnNotaFiscal.add(cadastrarNFMN);
		
		JMenuItem atualizarNFMN = new JMenuItem("Atualizar");
		atualizarNFMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarNota telaANota = new TelaAtualizarNota();
				frame.setContentPane(telaANota);
				frame.getContentPane().revalidate();
			}
		});
		mnNotaFiscal.add(atualizarNFMN);
		
		JMenuItem removerNFMN = new JMenuItem("Remover");
		removerNFMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverNota telaRNota = new TelaRemoverNota();
				frame.setContentPane(telaRNota);
				frame.getContentPane().revalidate();				
			}
		});
		mnNotaFiscal.add(removerNFMN);
		
		JMenuItem procurarNFMN = new JMenuItem("Procurar");
		procurarNFMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarNota telaPNota = new TelaProcurarNota();
				frame.setContentPane(telaPNota);
				frame.getContentPane().revalidate();
			}
		});
		mnNotaFiscal.add(procurarNFMN);
		
		JMenuItem listarNFMN = new JMenuItem("Listar");
		listarNFMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarNota telaLNota = new TelaListarNota();
				frame.setContentPane(telaLNota);
				frame.getContentPane().revalidate();
			}
		});
		mnNotaFiscal.add(listarNFMN);
		
		JMenuItem mntmEmitirNota = new JMenuItem("Emitir Nota");
		mnNotaFiscal.add(mntmEmitirNota);
	}

}
