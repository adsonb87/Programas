package br.aeso.projeto.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.ListaClienteVaziaException;

public class TelaListarCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListarCliente() {
		setBorder(new TitledBorder(null, "Listar Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JTextPane listarClientesTP = new JTextPane();
		
		JButton listarClientesBTN = new JButton("Listar Clientes");
		listarClientesBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada fachada = Fachada.getInstance();
				try {
					ArrayList<Cliente> lista = fachada.listarCliente();
					listarClientesTP.setText(lista.toString());
				} catch (ListaClienteVaziaException e1) {
					JOptionPane.showInputDialog(e1.getMessage());
				}
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(279)
							.addComponent(listarClientesBTN))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(listarClientesTP, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(listarClientesBTN)
					.addGap(18)
					.addComponent(listarClientesTP, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

}
