package br.aeso.projeto.gui.pedido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.notafiscal.NotaFiscal;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.NotaFiscalNaoEncontradaException;
import br.aeso.projeto.util.PedidoNaoEncontradoException;

public class TelaCadastrarPedido extends JPanel {
	private JTextField codigoNFTF;
	private JTextField codigoClienteTF;
	private JTextField codigoVendedorTF;
	private JTextField codigoPedidoTF;
	private JTextField codigoProdutoTF;
	private JTextField quantidadeTF;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarPedido() {
		setBorder(new TitledBorder(null, "Cadastrar Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigoNotaFiscal = new JLabel("Codigo Nota fiscal");
		
		codigoNFTF = new JTextField();
		codigoNFTF.setColumns(10);
		
		JLabel lblCodigoCliente = new JLabel("Codigo Cliente");
		
		codigoClienteTF = new JTextField();
		codigoClienteTF.setColumns(10);
		
		JLabel lblCodigoVendedor = new JLabel("Codigo Vendedor");
		
		codigoVendedorTF = new JTextField();
		codigoVendedorTF.setColumns(10);
		
		JLabel lblCodigoPedido = new JLabel("Codigo Pedido");
		
		codigoPedidoTF = new JTextField();
		codigoPedidoTF.setColumns(10);
		
		JLabel lblCodigoProduto = new JLabel("Codigo Produto");
		
		codigoProdutoTF = new JTextField();
		codigoProdutoTF.setColumns(10);
		
		JLabel lblQuantidadeProduto = new JLabel("Quantidade Produto");
		
		quantidadeTF = new JTextField();
		quantidadeTF.setColumns(10);
		
		JButton btnAdicionarPedido = new JButton("Adicionar Pedido");
		btnAdicionarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPedido();
			}
		});
		
		
		JButton btnFinalizarPedido = new JButton("Finalizar Pedido");
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigoNotaFiscal)
						.addComponent(lblCodigoPedido)
						.addComponent(lblCodigoProduto))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCodigoCliente)
							.addGap(18)
							.addComponent(codigoClienteTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCodigoVendedor)
							.addGap(18)
							.addComponent(codigoVendedorTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(codigoPedidoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(codigoProdutoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAdicionarPedido)
									.addGap(18)
									.addComponent(btnFinalizarPedido))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblQuantidadeProduto)
									.addGap(18)
									.addComponent(quantidadeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoNotaFiscal)
						.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigoCliente)
						.addComponent(codigoClienteTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigoVendedor)
						.addComponent(codigoVendedorTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoPedido)
						.addComponent(codigoPedidoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoProduto)
						.addComponent(codigoProdutoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidadeProduto)
						.addComponent(quantidadeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdicionarPedido)
						.addComponent(btnFinalizarPedido))
					.addContainerGap(222, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
//	private void cadastrarPedido(){
//		Fachada fachada = Fachada.getInstance();
//		try {
//			NotaFiscal notaFiscal = new NotaFiscal(codigoNFTF.getText(), fachada.procurarCliente(codigoClienteTF.getText()), fachada.procurarVendedor(codigoVendedorTF.getText()));
//			fachada.cadastrarNotaFiscal(notaFiscal);
//			Pedido pedido = new Pedido(notaFiscal, codigoPedidoTF.getText(), fachada.procurarProduto(codigoProdutoTF.getText()), Double.parseDouble(quantidadeTF.getText().replaceAll(",","."))); 
//			fachada.cadastrarPedido(pedido);
//			notaFiscal.adicionarPedido(pedido);
//			limparCamposAdicionar();
//		} catch (CodigoInexistenteException | NotaFiscalNaoEncontradaException | NumberFormatException | PedidoNaoEncontradoException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	
	private void cadastrarPedido(){
		Fachada fachada = Fachada.getInstance();
		try {
			NotaFiscal notaFiscal = inicializarNotaFiscal();
			fachada.cadastrarNotaFiscal(notaFiscal);
			Pedido pedido = new Pedido(notaFiscal, codigoPedidoTF.getText(), fachada.procurarProduto(codigoProdutoTF.getText()), Double.parseDouble(quantidadeTF.getText().replaceAll(",","."))); 
			fachada.cadastrarPedido(pedido);
			notaFiscal.adicionarPedido(pedido);
			limparCamposAdicionar();
		} catch (CodigoInexistenteException | NotaFiscalNaoEncontradaException | NumberFormatException | PedidoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private NotaFiscal inicializarNotaFiscal(){
		Fachada fachada = Fachada.getInstance();
		ArrayList<NotaFiscal> lista = fachada.listarNotaFiscal();
		for(int i=0; i<lista.size();i++){
			if(lista.get(i).getCodigoNotaFiscal().equals(codigoNFTF.getText())){
				return lista.get(i);
			}
		}
		try {
			return new NotaFiscal(codigoNFTF.getText(), fachada.procurarCliente(codigoClienteTF.getText()), fachada.procurarVendedor(codigoVendedorTF.getText()));
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	private void limparCamposAdicionar(){
		codigoPedidoTF.setText("");
		codigoProdutoTF.setText("");
		quantidadeTF.setText("");
	}
	
	private void limparCampos(){
		codigoNFTF.setText("");
		codigoClienteTF.setText("");
		codigoPedidoTF.setText("");
		codigoProdutoTF.setText("");
		codigoVendedorTF.setText("");
		quantidadeTF.setText("");
	}
	
}
