package br.aeso.projeto.gui.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.aeso.projeto.cliente.Cliente;
import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.CodigoInexistenteException;

public class TelaProcurarCliente extends JPanel {
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaProcurarCliente() {
		setBorder(new TitledBorder(null, "Procurar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigoCliente = new JLabel("Codigo");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton procurarBTN = new JButton("Procurar");
		procurarBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurarCliente(textPane);
			}
		});
		procurarBTN.setVerticalAlignment(SwingConstants.TOP);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCodigoCliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(311)
							.addComponent(procurarBTN))
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
						.addComponent(lblCodigoCliente)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(procurarBTN)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(202, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	private void procurarCliente(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		try {
			Cliente cliente = fachada.procurarCliente(codigoTF.getText());
			textPane.setText(cliente.toString());
			limparCampos();
		} catch (CodigoInexistenteException e) {
			System.out.println(e.getMessage());
		}
	}
	private void limparCampos(){
		codigoTF.setText("");
	}
}
