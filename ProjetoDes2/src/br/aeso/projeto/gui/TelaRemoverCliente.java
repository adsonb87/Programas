package br.aeso.projeto.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.CodigoInexistenteException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverCliente extends JPanel {
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaRemoverCliente() {
		setBorder(new TitledBorder(null, "Remover Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCdigoDoCliente = new JLabel("C\u00F3digo do cliente a ser removido:");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton removerBTN = new JButton("Remover");
		removerBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerCliente(textPane);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCdigoDoCliente)
							.addGap(18)
							.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(275)
							.addComponent(removerBTN))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigoDoCliente)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(removerBTN)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(292, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void removerCliente(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		try {
			if(fachada.removerCliente(codigoTF.getText())==true){
				textPane.setText("Cliente removido com sucesso");
				limparCampos();
			}else{
				textPane.setText("Codigo de cliente não encontrado");
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
