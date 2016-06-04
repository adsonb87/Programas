package br.aeso.projeto.gui.vendedor;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.vendedor.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaAtualizarVendedor extends JPanel {
	private JTextField codigoTF;
	private JTextField nomeTF;
	private JTextField enderecoTF;
	private JTextField telefoneTF;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarVendedor() {
		setBorder(new TitledBorder(null, "Atualizar Vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("Codigo");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JLabel label_1 = new JLabel("Nome");
		
		nomeTF = new JTextField();
		nomeTF.setColumns(10);
		
		JLabel label_2 = new JLabel("Endere\u00E7o");
		
		enderecoTF = new JTextField();
		enderecoTF.setColumns(10);
		
		JLabel label_3 = new JLabel("Telefone");
		
		telefoneTF = new JTextField();
		telefoneTF.setColumns(10);
		
		JButton button = new JButton("Gravar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarVendedor();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(312)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
								.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(telefoneTF, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(enderecoTF, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeTF, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(nomeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(enderecoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(telefoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(230, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void atualizarVendedor(){
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.atualizarVendedor(new Vendedor(codigoTF.getText(), nomeTF.getText(), enderecoTF.getText(), telefoneTF.getText()));
			limparCampos();
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void limparCampos(){
		codigoTF.setText("");
		nomeTF.setText("");
		enderecoTF.setText("");
		telefoneTF.setText("");
	}

}
