package br.aeso.projeto.gui.produto;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.CodigoInexistenteException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAtualizarProduto extends JPanel {
	private JTextField data;
	private JTextField preco;
	private JTextField nome;
	private JTextField codigo;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarProduto() {
		setBorder(new TitledBorder(null, "Atualizar Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		
		JLabel lblDataVencimento = new JLabel("Data vencimento");
		
		data = new JTextField();
		data.setColumns(10);
		
		preco = new JTextField();
		preco.setColumns(10);
		
		nome = new JTextField();
		nome.setColumns(10);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarProduto();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataVencimento)
						.addComponent(lblPreo)
						.addComponent(lblNome)
						.addComponent(lblCodigo))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(nome, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
						.addComponent(codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(data, Alignment.LEADING)
							.addComponent(preco, Alignment.LEADING)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(325, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addGap(308))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreo)
						.addComponent(preco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataVencimento)
						.addComponent(data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAtualizar)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void atualizarProduto(){
		try {
			Fachada fachada = Fachada.getInstance();
			fachada.atualizarProduto(new Produto(codigo.getText(), nome.getText(), Double.parseDouble(preco.getText().replaceAll(",", ".")), data.getText()));
			limparCampos();
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void limparCampos(){
		codigo.setText("");
		nome.setText("");
		preco.setText("");
		data.setText("");
	}
	
}
