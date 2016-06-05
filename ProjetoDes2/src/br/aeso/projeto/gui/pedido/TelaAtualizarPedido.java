package br.aeso.projeto.gui.pedido;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.util.CodigoInexistenteException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarPedido extends JPanel {
	private JTextField codigoPedidoTF;
	private JTextField codigoNFTF;
	private JTextField codigoProdutoTF;
	private JTextField quantidadeProdutoTF;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarPedido() {
		setBorder(new TitledBorder(null, "Atualizar Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigoPedido = new JLabel("Codigo Pedido");
		
		codigoPedidoTF = new JTextField();
		codigoPedidoTF.setColumns(10);
		
		JLabel lblCodigoNotaFiscal = new JLabel("Codigo Nota fiscal");
		
		codigoNFTF = new JTextField();
		codigoNFTF.setColumns(10);
		
		JLabel lblCodigoProduto = new JLabel("Codigo Produto");
		
		codigoProdutoTF = new JTextField();
		codigoProdutoTF.setColumns(10);
		
		JLabel lblQuantidadeDoProduto = new JLabel("Quantidade do Produto");
		
		quantidadeProdutoTF = new JTextField();
		quantidadeProdutoTF.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarPedido();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblQuantidadeDoProduto)
							.addGap(18)
							.addComponent(quantidadeProdutoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCodigoNotaFiscal)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCodigoProduto)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(codigoProdutoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCodigoPedido)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(codigoPedidoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(482, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(313, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addGap(306))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoPedido)
						.addComponent(codigoPedidoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoNotaFiscal)
						.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoProduto)
						.addComponent(codigoProdutoTF))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantidadeDoProduto)
						.addComponent(quantidadeProdutoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAtualizar)
					.addGap(251))
		);
		setLayout(groupLayout);

	}
	private void atualizarPedido(){
		try {
			Fachada fachada = Fachada.getInstance();
			fachada.atualizarPedido(new Pedido(fachada.procurarNotaFiscal(codigoNFTF.getText()), codigoPedidoTF.getText(), fachada.procurarProduto(codigoProdutoTF.getText()), Double.parseDouble(quantidadeProdutoTF.getText().replaceAll(",", "."))));
			limparCampos();
		} catch (NumberFormatException | CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void limparCampos(){
		codigoNFTF.setText("");
		codigoPedidoTF.setText("");
		codigoProdutoTF.setText("");
		quantidadeProdutoTF.setText("");
	}
}
