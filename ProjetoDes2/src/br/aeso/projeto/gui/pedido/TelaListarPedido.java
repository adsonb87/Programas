package br.aeso.projeto.gui.pedido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.pedido.Pedido;

public class TelaListarPedido extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListarPedido() {
		setBorder(new TitledBorder(null, "Listar Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JTextPane textPane = new JTextPane();
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPedidos(textPane);
			}
		});
		
		
		textPane.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(275)
							.addComponent(btnListar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnListar)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	private void listarPedidos(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		ArrayList<Pedido> lista = fachada.listarPedido();
		if(!lista.isEmpty()){
			textPane.setText(lista.toString());
		}else{
			textPane.setText("Não há pedidos para serem listados");
		}
		
		
	}
}
