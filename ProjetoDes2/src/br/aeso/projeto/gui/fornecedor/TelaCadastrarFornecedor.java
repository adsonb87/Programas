package br.aeso.projeto.gui.fornecedor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.fornecedor.Fornecedor;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.FornecedorNaoEncontradoException;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarFornecedor extends JPanel {
	private JTextField codigoTF;
	private JTextField nomeTF;
	private JTextField enderecoTF;
	private JTextField telefoneTF;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarFornecedor() {
		setBorder(new TitledBorder(null, "Cadastrar Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("Codigo");
		
		JLabel label_1 = new JLabel("Nome");
		
		JLabel label_2 = new JLabel("Endere\u00E7o");
		
		JLabel label_3 = new JLabel("Telefone");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		nomeTF = new JTextField();
		nomeTF.setColumns(10);
		
		enderecoTF = new JTextField();
		enderecoTF.setColumns(10);
		
		telefoneTF = new JTextField();
		telefoneTF.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarFornecedor();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(telefoneTF, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
								.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(nomeTF)
								.addComponent(enderecoTF, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))))
					.addGap(13))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(320, Short.MAX_VALUE)
					.addComponent(btnGravar)
					.addGap(323))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(telefoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(nomeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(enderecoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(btnGravar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(211))
		);
		setLayout(groupLayout);
			
	}
	
	private void limparCampos(){
		codigoTF.setText("");
		nomeTF.setText("");
		enderecoTF.setText("");
		telefoneTF.setText("");
	}
	
	private void cadastrarFornecedor(){
		try {
			Fornecedor fornecedor = new Fornecedor(codigoTF.getText(), nomeTF.getText(), enderecoTF.getText(), telefoneTF.getText());
			Fachada fachada = Fachada.getInstance();
			fachada.cadastrarFornecedor(fornecedor);
			limparCampos();
		} catch (FornecedorNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
