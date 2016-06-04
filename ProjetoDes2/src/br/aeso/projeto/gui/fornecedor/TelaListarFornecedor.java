package br.aeso.projeto.gui.fornecedor;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.fornecedor.Fornecedor;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaListarFornecedor extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListarFornecedor() {
		setBorder(new TitledBorder(null, "Listar Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton listarFornecedorBTN = new JButton("Listar Fornecedores");
		listarFornecedorBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarFornecedor(textPane);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(281)
							.addComponent(listarFornecedorBTN)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addComponent(listarFornecedorBTN)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
	private void listarFornecedor(JTextPane textPane ){
		Fachada fachada = Fachada.getInstance();
		ArrayList<Fornecedor> lista = fachada.listarFornecedor();
		if(!lista.isEmpty()){
			textPane.setText(lista.toString());
		}else{
			textPane.setText("Não há clientes para serem listados");
		}
	}
}
