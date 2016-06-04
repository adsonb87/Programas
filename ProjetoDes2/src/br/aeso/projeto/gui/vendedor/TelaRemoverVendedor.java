package br.aeso.projeto.gui.vendedor;

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

public class TelaRemoverVendedor extends JPanel {
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaRemoverVendedor() {
		setBorder(new TitledBorder(null, "Remover Vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerVendedor(textPane);				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCodigo)
							.addGap(18)
							.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(296)
							.addComponent(btnNewButton))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(290, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void removerVendedor(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		try {
			if(fachada.removerVendedor(codigoTF.getText())==true){
				textPane.setText("Vendedor removido com sucesso");
				limparCampos();
			}else{
				textPane.setText("Codigo não encontrado");
				limparCampos();
			}
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void limparCampos(){
		codigoTF.setText("");
	}
}
