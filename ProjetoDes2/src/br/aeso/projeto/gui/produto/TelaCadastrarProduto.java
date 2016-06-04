package br.aeso.projeto.gui.produto;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.produto.Produto;
import br.aeso.projeto.util.ProdutoNaoEncontradoException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaCadastrarProduto extends JPanel {
	private JTextField dtVencimentoTF;
	private JTextField precoTF;
	private JTextField codigoTF;
	private JTextField nomeTF;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarProduto() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastrar Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		
		JLabel lblDataDeVencimento = new JLabel("Data de vencimento");
		
		dtVencimentoTF = new JTextField();
		dtVencimentoTF.setColumns(10);
		
		precoTF = new JTextField();
		precoTF.setColumns(10);
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		nomeTF = new JTextField();
		nomeTF.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProduto();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataDeVencimento)
						.addComponent(lblPreo)
						.addComponent(lblCodigo)
						.addComponent(lblNome))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(precoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dtVencimentoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(216)
							.addComponent(btnGravar))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nomeTF, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(nomeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreo)
						.addComponent(precoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeVencimento)
						.addComponent(dtVencimentoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnGravar)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	private void cadastrarProduto(){		
		try {
			Fachada fachada = Fachada.getInstance();
			fachada.cadastrarProduto(new Produto(codigoTF.getText(), nomeTF.getText(), Double.parseDouble(precoTF.getText().replaceAll(",", ".")), dtVencimentoTF.getText()));
			limparCampos();
		} catch (NumberFormatException | ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private void limparCampos(){
		codigoTF.setText("");
		nomeTF.setText("");
		precoTF.setText("");
		dtVencimentoTF.setText("");
	}

}
