package br.aeso.projeto.gui.produto;

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
import br.aeso.projeto.produto.Produto;

public class TelaListarProduto extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListarProduto() {
		setBorder(new TitledBorder(null, "Listar Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		JButton btnListarProdutos = new JButton("Listar Produtos");
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarProduto(textPane);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(285)
							.addComponent(btnListarProdutos))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnListarProdutos)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	private void listarProduto(JTextPane listar){
		Fachada fachada = Fachada.getInstance();
		ArrayList<Produto> lista = fachada.listarProduto();
		if(!lista.isEmpty()){
			listar.setText(lista.toString());
		}else{
			listar.setText("Não há produtos para serem listados");
		}
	}
}
