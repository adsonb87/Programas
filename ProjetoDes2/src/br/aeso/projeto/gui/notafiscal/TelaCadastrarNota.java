package br.aeso.projeto.gui.notafiscal;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.notafiscal.NotaFiscal;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.util.NotaFiscalNaoEncontradaException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastrarNota extends JPanel {
	private JTextField codigoNFTF;
	private JTextField codigoVendedorTF;
	private JTextField codigoClienteTF;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarNota() {
		setBorder(new TitledBorder(null, "Cadastrar Nota", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigo = new JLabel("Codigo Nota fiscal");
		
		JLabel lblCodigoCliente = new JLabel("Codigo Cliente");
		
		JLabel lblCodigoVendedor = new JLabel("Codigo Vendedor");
		
		codigoNFTF = new JTextField();
		codigoNFTF.setColumns(10);
		
		codigoVendedorTF = new JTextField();
		codigoVendedorTF.setColumns(10);
		
		codigoClienteTF = new JTextField();
		codigoClienteTF.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarNotaFiscal();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCodigo)
						.addComponent(lblCodigoVendedor)
						.addComponent(lblCodigoCliente))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(codigoClienteTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(codigoVendedorTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(508, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(315, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addGap(304))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoCliente)
						.addComponent(codigoClienteTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoVendedor)
						.addComponent(codigoVendedorTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCadastrar)
					.addContainerGap(289, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void cadastrarNotaFiscal(){
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.cadastrarNotaFiscal(new NotaFiscal(codigoNFTF.getText(), fachada.procurarCliente(codigoClienteTF.getText()), fachada.procurarVendedor(codigoVendedorTF.getText())));
			limparCampos();
		} catch (NotaFiscalNaoEncontradaException | CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void limparCampos(){
		codigoClienteTF.setText("");
		codigoNFTF.setText("");
		codigoVendedorTF.setText("");
	}
	

}
