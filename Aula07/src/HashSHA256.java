import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HashSHA256 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea txtTexto = new JTextArea();
	private JScrollPane jspTexto = new JScrollPane(txtTexto);
	private JTextField txtResumo = new JTextField();
	private JButton btnCalcular = new JButton("Calcular Hash");
	

	public static void main(String[] agrs) {
		new HashSHA256().setVisible(true);
	}
	
	
	public HashSHA256() {
		
		setTitle("programa de calculo do resumo unidirecionar SHA-256");
		setSize(600, 500);
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setLayout(null);
		
	
	//Configuração da area de texto 
		jspTexto.setBounds(40, 10, 500, 300);
		add(jspTexto);
		txtTexto.setLineWrap(true);
	
	//Configuração da caixa do hash
		txtResumo.setBounds(40, 320, 500, 20);
		add(txtResumo);
		
	//Configuração do botão
		btnCalcular.setBounds(200, 350, 200, 30);
		add(btnCalcular);
		btnCalcular.addActionListener(new ControladorCalcular(txtTexto, txtResumo));
	}
}

