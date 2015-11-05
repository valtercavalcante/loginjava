import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(113, 168, 93, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexao conexao = new Conexao();
				conexao.conectar();
				BoasVindas bv = new BoasVindas();
				if(conexao.verificaLogin(login.getText(), senha.getText())){
					bv.show();
				}
				else{
					//bv.hide();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLogin);
		
		login = new JTextField();
		login.setBounds(113, 87, 203, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(115, 137, 203, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(113, 74, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(113, 124, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSenha = new JButton("Cancelar");
		btnSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSenha.setBounds(223, 168, 93, 23);
		contentPane.add(btnSenha);
	}
}
