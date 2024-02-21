package jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
  
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.recuperaConexion()){
			System.out.println("Conexion exitosa a la base de datos.");
		}catch(SQLException e) {
			System.out.println("Error al conectar a la base de datos " + e.getMessage());
		}
	}
}
