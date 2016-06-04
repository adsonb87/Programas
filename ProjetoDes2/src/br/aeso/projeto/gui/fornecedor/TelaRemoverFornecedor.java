package br.aeso.projeto.gui.fornecedor;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.CodigoInexistenteException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class TelaRemoverFornecedor extends JPanel {
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaRemoverFornecedor() {
		setBorder(new TitledBorder(null, "Remover Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("C\u00F3digo do cliente a ser removido:");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton removerBTN = new JButton("Remover");
		removerBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerFornecedor(textPane);				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(265)
							.addComponent(removerBTN, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(removerBTN)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(318, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	private void removerFornecedor(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		try {
			if(fachada.removerFornecedor(codigoTF.getText())==true){
				textPane.setText("Fornecedor removido com sucesso");
				limparCampos();
			}else{
				textPane.setText("Codigo de fornecedor não encontrado");
				limparCampos();
			}
		} catch (CodigoInexistenteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void limparCampos(){
		codigoTF.setText("");
	}

}
