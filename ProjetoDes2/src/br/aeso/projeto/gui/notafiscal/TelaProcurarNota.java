package br.aeso.projeto.gui.notafiscal;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.xml.ws.FaultAction;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.notafiscal.NotaFiscal;
import br.aeso.projeto.util.CodigoInexistenteException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaProcurarNota extends JPanel {
	private JTextField codigoNFTF;

	/**
	 * Create the panel.
	 */
	public TelaProcurarNota() {
		setBorder(new TitledBorder(null, "Procurar Nota", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigo = new JLabel("Codigo ");
		
		codigoNFTF = new JTextField();
		codigoNFTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurarNotaFiscal(textPane);
			}
		});
		
		textPane.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCodigo)
							.addGap(18)
							.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(285)
							.addComponent(btnProcurar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(codigoNFTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnProcurar)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(284, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void limparCampos(){
		codigoNFTF.setText("");
	}
	
	private void procurarNotaFiscal(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		try {
			NotaFiscal notaFiscal = fachada.procurarNotaFiscal(codigoNFTF.getText());
			textPane.setText(notaFiscal.toString());
			limparCampos();
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
