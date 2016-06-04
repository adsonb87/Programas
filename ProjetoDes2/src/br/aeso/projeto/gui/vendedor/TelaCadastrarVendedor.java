package br.aeso.projeto.gui.vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.VendedorNaoEncontradoException;
import br.aeso.projeto.vendedor.Vendedor;

public class TelaCadastrarVendedor extends JPanel {
	private JTextField enderecoTF;
	private JTextField telefoneTF;
	private JTextField nomeTF;
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarVendedor() {
		setBorder(new TitledBorder(null, "Cadastrar Vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel = new JLabel("Codigo");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		
		enderecoTF = new JTextField();
		enderecoTF.setColumns(10);
		
		telefoneTF = new JTextField();
		telefoneTF.setColumns(10);
		
		nomeTF = new JTextField();
		nomeTF.setColumns(10);
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarVendedor();
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
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeTF, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
								.addComponent(enderecoTF, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
								.addComponent(telefoneTF, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(322)
							.addComponent(btnGravar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
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
					.addComponent(btnGravar)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void cadastrarVendedor(){
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.cadastrarVendedor(new Vendedor(codigoTF.getText(), nomeTF.getText(), enderecoTF.getText(), telefoneTF.getText()));
			limparCampos();
		} catch (VendedorNaoEncontradoException e) {
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
