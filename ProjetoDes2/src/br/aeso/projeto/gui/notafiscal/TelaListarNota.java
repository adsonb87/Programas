package br.aeso.projeto.gui.notafiscal;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.fornecedor.Fornecedor;
import br.aeso.projeto.notafiscal.NotaFiscal;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaListarNota extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaListarNota() {
		setBorder(new TitledBorder(null, "Listar Nota Fiscal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JTextPane textPane = new JTextPane();
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarNotaFiscal(textPane);
			}
		});
		
		textPane.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(304)
					.addComponent(btnListar)
					.addContainerGap(345, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE)
					.addGap(159))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnListar)
					.addGap(18)
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
			
	private void listarNotaFiscal(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		ArrayList<NotaFiscal> lista = fachada.listarNotaFiscal();
		if(!lista.isEmpty()){
			textPane.setText(lista.toString());
		}else{
			textPane.setText("Não há notas para serem listadas");
		}
	}
}
