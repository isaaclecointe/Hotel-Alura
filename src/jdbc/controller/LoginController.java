package jdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.factory.ConnectionFactory;

public class LoginController {

	  private final ConnectionFactory connectionFactory;
	  
	  public LoginController() {
		  this.connectionFactory = new ConnectionFactory();
	  }
	  
	  public boolean login(String usuario, String contrasena) {
		  try(Connection connection = connectionFactory.recuperaConexion()){
			  String sql = "SELECT COUNT(*) FROM alurahotel.usuarios WHERE usuario = ? AND contraseña = ?";
			  try(PreparedStatement statement = connection.prepareStatement(sql)){
				  statement.setString(1, usuario);
				  statement.setString(2, contrasena);
				  
				  try(ResultSet resultSet = statement.executeQuery()){
					  if(resultSet.next()) {
						  int count = resultSet.getInt(1);
						  return count > 0;
					  }
				  }
			  }
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		  
		  return false;
	  }
}
