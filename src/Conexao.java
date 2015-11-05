import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {
	public boolean retorno;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void conectar(){
		String servidor = "jdbc:mysql://localhost/javateste";
		String usuario =  "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		try{
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario , senha);
			this.statement = this.connection.createStatement();
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public boolean verificaLogin(String nome, String cpf){
		try{
			String query = "Select nome, cpf from usuario where nome='"+nome+"' and cpf ='"+cpf+"'";
			this.resultSet = this.statement.executeQuery(query);
			if (this.resultSet.next()){
				JOptionPane.showMessageDialog(null, "login encontrado");
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null, "login não encontrado");
				return false;
			}
		}catch(Exception e){
			System.out.println("Erro:"+ e.getMessage());
			return false;
		}
		
	}
	public boolean insereLogin (String nome, String cpf){
		try{
			String query = "Insert into usuario (nome, cpf) values ('"+nome+"','"+cpf+"')";
			this.statement.executeUpdate(query);
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
		return true;
	}
}