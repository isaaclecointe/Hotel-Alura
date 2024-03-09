package jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;


   /**
    * Clase de prueba para verficar la conexion con la base de datos.
    * Utiliza COnnectionFactory para establecer la conexion.
    */
public class PruebaConexion {
  
	public static void main(String[] args) {
		
		//Intenta establecer una conexion con la base de datos y manejar las posibles excepcions SQL.
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.recuperaConexion()){
			System.out.println("Conexion exitosa a la base de datos.");
		}catch(SQLException e) {
			System.out.println("Error al conectar a la base de datos " + e.getMessage());
		}
	}
}
