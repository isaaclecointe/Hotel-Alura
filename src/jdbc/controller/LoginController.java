package jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.factory.ConnectionFactory;

  /**
   * Clase que se encarga del Login del Usuario para entrar al sistema.
   */

public class LoginController {
      
	//Crea las conexiones para la base de datos 
	  private final ConnectionFactory connectionFactory;
	  
	  
	  //Contructor que inicializa la conexion con la Base de datos
	  public LoginController() { 
		  this.connectionFactory = new ConnectionFactory();
	  }
	  
	  // Metodo de Login del Usuario 
	  public boolean login(String usuario, String contrasena) {
		  
	          // se establece la conexion con la base de datos try-with-resources para asegurar que se cierre.
		  try(Connection connection = connectionFactory.recuperaConexion()){
			  
			  // Utilizamos PreparedStatement para prevenir inyecciones SQL y manejar los parametros de manera segura.
			  String sql = "SELECT COUNT(*) FROM alurahotel.usuarios WHERE usuario = ? AND contraseña = ?";
			  try(PreparedStatement statement = connection.prepareStatement(sql)){
				  statement.setString(1, usuario);
				  statement.setString(2, contrasena);
				  
				  // Ejecucion de la consulta y verificacion si hay  coincidencias.
				  try(ResultSet resultSet = statement.executeQuery()){
					  if(resultSet.next()) {
						  int count = resultSet.getInt(1);
						  // si hay coincidencia, el inicio de sesion exitoso
						  return count > 0;
					  }
				  }
			  }
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		  // si no hay coincidencias, inicio de sesion falla
		  return false;
	  }
}
