package jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


   /**
    * Clase que gestiona la creacion de conexiones con la base de datos PostgreSQL
    * Utiliza ComboPooledDataSource para manejar el pool de conexiones.
    */
public class ConnectionFactory {

	public DataSource datasource;
	
	/**
	 * Constructor que inicializa el DataSource con la configuracion de conexion.
	 */
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/HotelAlura?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("postgres");
		comboPooledDataSource.setPassword("1234");
		
		this.datasource = comboPooledDataSource;
	}
	
	/**
	 * Metodo para recuperar una conexion del pool de conexiones.
	 * @return Una nueva conexion a la base de datos.
	 * @throws RuntimeException si ocurre un error al recuperar la conexion.
	 */
	
	public Connection recuperaConexion() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error al recuperar la conexion");
		}
	}
}
