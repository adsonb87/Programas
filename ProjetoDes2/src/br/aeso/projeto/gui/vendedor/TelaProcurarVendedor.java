package br.aeso.projeto.gui.vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.CodigoInexistenteException;
import br.aeso.projeto.vendedor.Vendedor;

public class TelaProcurarVendedor extends JPanel {
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaProcurarVendedor() {
		setBorder(new TitledBorder(null, "Procurar Vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton btnProdurar = new JButton("Procurar");
		btnProdurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurarVendedor(textPane);
			}
		});
		
		
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
							.addGap(285)
							.addComponent(btnProdurar))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)))
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
					.addComponent(btnProdurar)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(278, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void limparCampos(){
		codigoTF.setText("");
	}
	
	private void procurarVendedor(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		try {
			Vendedor vendedor = fachada.procurarVendedor(codigoTF.getText());
			textPane.setText(vendedor.toString());
			limparCampos();
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
