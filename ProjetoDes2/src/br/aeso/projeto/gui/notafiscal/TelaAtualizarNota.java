package br.aeso.projeto.gui.notafiscal;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.notafiscal.NotaFiscal;
import br.aeso.projeto.util.CodigoInexistenteException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarNota extends JPanel {
	private JTextField codigoNFTF;
	private JTextField codigoClienteTF;
	private JTextField codigoVendedorTF;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarNota() {
		setBorder(new TitledBorder(null, "Atualizar Nota", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigoNotaFiscal = new JLabel("Codigo Nota fiscal");
		
		JLabel lblCodigoCliente = new JLabel("Codigo Cliente");
		
		JLabel lblCodigoVendedor = new JLabel("Codigo Vendedor");
		
		codigoNFTF = new JTextField();
		codigoNFTF.setColumns(10);
		
		codigoClienteTF = new JTextField();
		codigoClienteTF.setColumns(10);
		
		codigoVendedorTF = new JTextField();
		codigoVendedorTF.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarNotaFiscal();
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
								.addComponent(lblCodigoNotaFiscal)
								.addComponent(lblCodigoCliente)
								.addComponent(lblCodigoVendedor))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(codigoVendedorTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(codigoClienteTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(295)
							.addComponent(btnAtualizar)))
					.addContainerGap(324, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoNotaFiscal)
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
					.addComponent(btnAtualizar)
					.addContainerGap(289, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void limparCampos(){
		codigoClienteTF.setText("");
		codigoNFTF.setText("");
		codigoVendedorTF.setText("");
	}
	
	private void atualizarNotaFiscal(){
		try {
			Fachada fachada = Fachada.getInstance();
			fachada.atualizarNotaFiscal(new NotaFiscal(codigoNFTF.getText(), fachada.procurarCliente(codigoClienteTF.getText()), fachada.procurarVendedor(codigoVendedorTF.getText())));
			limparCampos();
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
