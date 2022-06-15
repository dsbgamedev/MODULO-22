package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	private static String banco = "jdbc:postgresql://localhost:5433/curso.jsp?autoReconnect=true";
	private static String user = "postgre";
	private static String senha = "admin";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {/*De qualquer ligar que chamar a classe vai conectar*/
		conectar();
	}
	
	
	public SingleConnectionBanco() {/*qunado tiver uma instancia vai conectar*/
		conectar();
	}
	
	private static void conectar() {
		
		try {
			if(connection == null) {
				Class.forName("org.postgresql.driver");/*carrega o driver de conexão do banco*/
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false);/*Para nao efetuar alteraões no banco sem nosso comando*/
			}
		} catch (Exception e) {
			e.printStackTrace();/*Mostrar qualquer erro no momento de conectar*/
		}
	}
	
	
}
