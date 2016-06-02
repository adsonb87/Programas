package br.aeso.projeto.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.CodigoInexistenteException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarCliente extends JPanel {
	private JTextField codigoTF;
	private JTextField nomeTF;
	private JTextField enderecoTF;
	private JTextField telefoneTF;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarCliente() {
		setBorder(new TitledBorder(null, "Atualizar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel Codigo = new JLabel("Codigo");
		
		JLabel Nome = new JLabel("Nome");
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		nomeTF = new JTextField();
		nomeTF.setColumns(10);
		
		enderecoTF = new JTextField();
		enderecoTF.setColumns(10);
		
		telefoneTF = new JTextField();
		telefoneTF.setColumns(10);
		
		JButton atualizarBTN = new JButton("Atualizar Cliente");
		atualizarBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarCliente();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(Nome)
								.addComponent(Codigo)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeTF, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
								.addComponent(enderecoTF)
								.addComponent(telefoneTF)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(306)
							.addComponent(atualizarBTN)))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Codigo)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Nome)
						.addComponent(nomeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(enderecoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(telefoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(atualizarBTN)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void atualizarCliente(){
		try {
			Cliente cliente = new Cliente(codigoTF.getText(), nomeTF.getText(), enderecoTF.getText(), telefoneTF.getText());
			Fachada fachada = Fachada.getInstance();
			fachada.atualizarCliente(cliente);
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
