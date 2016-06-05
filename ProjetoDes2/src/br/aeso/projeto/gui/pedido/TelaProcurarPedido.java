package br.aeso.projeto.gui.pedido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.pedido.Pedido;
import br.aeso.projeto.util.CodigoInexistenteException;

public class TelaProcurarPedido extends JPanel {
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaProcurarPedido() {
		setBorder(new TitledBorder(null, "Procurar Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigoPedido = new JLabel("Codigo Pedido");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurarPedido(textPane);
			}
		});
		
		textPane.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCodigoPedido)
							.addGap(18)
							.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(276)
							.addComponent(btnProcurar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoPedido)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnProcurar)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(216, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	private void procurarPedido(JTextPane textPane){
		try {
			Fachada fachada = Fachada.getInstance();
			Pedido pedido = fachada.procurarPedido(codigoTF.getText());
			textPane.setText(pedido.toString());
			limparCampos();
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void limparCampos(){
		codigoTF.setText("");
	}
}
