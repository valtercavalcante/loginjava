import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(60, 81, 191, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(60, 62, 46, 14);
		contentPane.add(lblNome);
		
		cpf = new JTextField();
		cpf.setBounds(60, 131, 167, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(60, 112, 46, 14);
		contentPane.add(lblCpf);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexao con = new Conexao();
				con.conectar();
				if(con.insereLogin(nome.getText(), cpf.getText())){
					JOptionPane.showMessageDialog(null, "Cadastro realizado");
				}
				else{
					JOptionPane.showMessageDialog(null, "Problemas ao cadastrar");
				}
			}
		});
		btnCadastrar.setBounds(57, 165, 102, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(162, 165, 89, 23);
		contentPane.add(btnCancelar);
	}
}
