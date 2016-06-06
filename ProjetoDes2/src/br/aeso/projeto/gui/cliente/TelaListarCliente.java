package br.aeso.projeto.gui.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;

public class TelaListarCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListarCliente() {
		setBorder(new TitledBorder(null, "Listar Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JTextPane listarClientesTP = new JTextPane();
		listarClientesTP.setEditable(false);
		
		JButton listarClientesBTN = new JButton("Listar Clientes");
		listarClientesBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarCliente(listarClientesTP);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(279)
							.addComponent(listarClientesBTN))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(listarClientesTP, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(listarClientesBTN)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(listarClientesTP, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
	
	private void listarCliente(JTextPane listar){
		Fachada fachada = Fachada.getInstance();
		ArrayList<Cliente> lista = fachada.listarCliente();
		if(!lista.isEmpty()){
			listar.setText(lista.toString());
		}else{
			listar.setText("Não há clientes para serem listados");
		}
	}
}
