import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControladorCalcular implements ActionListener {
	//Propriedades da classe
	private JTextArea txtTexto = null;
	private JTextField txtResumo = null;
	
	//Método construtor cheio da classe
	public ControladorCalcular(JTextArea txtTexto, JTextField txtResumo) {
		super();
		this.txtTexto = txtTexto;
		this.txtResumo = txtResumo;
	}
	
	//Método implementado da interface
	public void actionPerformed(ActionEvent e) {
		try {
			txtResumo.setText(calcularHash(txtTexto.getText()));
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
	
	//Métodos da classe
	private String calcularHash(String texto) throws Exception{
		String retorno = "";
		
		MessageDigest objHash = MessageDigest.getInstance("SHA-256");
		byte [] vetor = objHash.digest(texto.getBytes("UTF-8"));
		
		for (int i = 0; i < vetor.length; i++) {
			String letra = Integer.toHexString(0xFF & vetor[i]);
			if (letra.length() == 1) {
				letra = "0" + letra;
			}
			retorno += letra;
		}
		
		return retorno;
	}
}
