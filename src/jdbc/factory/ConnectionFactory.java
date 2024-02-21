package jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource datasource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/HotelAlura?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("postgres");
		comboPooledDataSource.setPassword("1234");
		
		this.datasource = comboPooledDataSource;
	}
	
	public Connection recuperaConexion() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error al recuperar la conexion");
		}
	}
}
