package br.aeso.projeto.gui.notafiscal;

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

public class TelaRemoverNota extends JPanel {
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaRemoverNota() {
		setBorder(new TitledBorder(null, "Remover Nota", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerNotaFiscal(textPane);
			}
		});
		
		textPane.setEditable(false);
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
							.addGap(299)
							.addComponent(btnRemover))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 693, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnRemover)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(261, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	private void limparCampos(){
		codigoTF.setText("");
	}
	
	private void removerNotaFiscal(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		try {
			if(fachada.removerNotaFiscal(codigoTF.getText())==true){
				textPane.setText("Nota Fiscal removida com sucesso");
				limparCampos();
			}else{
				textPane.setText("Codigo de Nota Fiscal não encontrado");
				limparCampos();
			}
		} catch (CodigoInexistenteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
