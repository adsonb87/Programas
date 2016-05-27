package br.aeso.projeto.gui;

import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.fornecedor.Fornecedor;
import br.aeso.projeto.util.ClienteNaoEncontradoException;
import br.aeso.projeto.util.ListaClienteVaziaException;

public class TelaAdicionarCliente extends JPanel {
	private JTextField nomeTF;
	private JTextField enderecoTF;
	private JTextField telefoneTF;
	private JTextField codigoTF;
	
	/**
	 * Create the panel.
	 */
	public TelaAdicionarCliente(){
		setBorder(new TitledBorder(null, "Adicionar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblNewLabel = new JLabel("Endere\u00E7o");
		
		JLabel lblNewLabel_1 = new JLabel("Telefone");
				
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		
		nomeTF = new JTextField();
		nomeTF.setColumns(10);
		
		enderecoTF = new JTextField();
		enderecoTF.setColumns(10);
		
		telefoneTF = new JTextField();
		telefoneTF.setColumns(10);
		
		JButton gravarBTN = new JButton("Gravar");
		gravarBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				try {
					Cliente cliente = new Cliente(codigoTF.getText(), nomeTF.getText(), enderecoTF.getText(), telefoneTF.getText());
					Fachada fachada = Fachada.getInstance();
					fachada.cadastrarCliente(cliente);
					limparCampos();
				} catch (ClienteNaoEncontradoException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(lblNome)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(telefoneTF)
							.addComponent(nomeTF, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
							.addComponent(enderecoTF))
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(299)
					.addComponent(gravarBTN)
					.addContainerGap(344, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(nomeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(enderecoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(telefoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(gravarBTN)
					.addContainerGap(252, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
			
	}
	
	private void limparCampos(){
		codigoTF.setText("");
		nomeTF.setText("");
		enderecoTF.setText("");
		telefoneTF.setText("");
	}

}
