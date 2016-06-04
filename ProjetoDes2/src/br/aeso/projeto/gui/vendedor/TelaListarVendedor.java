package br.aeso.projeto.gui.vendedor;

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
import br.aeso.projeto.vendedor.Vendedor;

public class TelaListarVendedor extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListarVendedor() {
		setBorder(new TitledBorder(null, "Listar Vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarVendedor(textPane);			
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(295)
							.addComponent(btnListar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 681, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnListar)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void listarVendedor(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		ArrayList<Vendedor> lista = fachada.listarVendedor();
		if(!lista.isEmpty()){
			textPane.setText(lista.toString());
		}else{
			textPane.setText("Não há vendedores para serem listados");
		}
	}

}
