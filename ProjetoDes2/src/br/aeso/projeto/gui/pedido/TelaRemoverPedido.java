package br.aeso.projeto.gui.pedido;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.xml.soap.Text;

import br.aeso.projeto.fachada.Fachada;
import br.aeso.projeto.util.CodigoInexistenteException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverPedido extends JPanel {
	private JTextField codigoTF;

	/**
	 * Create the panel.
	 */
	public TelaRemoverPedido() {
		setBorder(new TitledBorder(null, "RemoverPedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblCodigoPedido = new JLabel("Codigo Pedido");
		
		codigoTF = new JTextField();
		codigoTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPedido(textPane);
			}
		});
		
		textPane.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCodigoPedido)
							.addGap(18)
							.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(264)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoPedido)
						.addComponent(codigoTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void removerPedido(JTextPane textPane){
		Fachada fachada = Fachada.getInstance();
		try {
			if(fachada.removerPedido(codigoTF.getText())==true){
				textPane.setText("Pedido removido com sucesso");
				limparCampos();
			}else{
				textPane.setText("Codigo do pedido não encontrado");
				limparCampos();
			}
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void limparCampos(){
		codigoTF.setText("");
	}
}
