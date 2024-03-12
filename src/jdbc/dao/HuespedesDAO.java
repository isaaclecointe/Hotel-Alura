package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Huespedes;


/**
 * 
 *  DAO clase para manejar las operaciones de la base de datos relacionadas con los huespedes del hotel.
 *  permite insertar, buscar, actualizar y eliminar huespedes en la base de datos.
 *  
 */

public class HuespedesDAO {

	private Connection connection;
	
	public HuespedesDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	/**
	 * Metodo para insertar un nuevo huesped en la base de datos
	 * Retorna los ID auto generados 
	 */
	public void guardarHuesped(Huespedes huesped) {
		try {
			String sql = "INSERT INTO alurahotel.huespedes (nombre, apellido, fechanacimiento, nacionalidad, telefono, idreserva)VALUES(?,?,?,?,?,?)";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, huesped.getNombre());
				pstm.setString(2, huesped.getApellido());
				pstm.setDate(3, huesped.getFechaNacimiento());
				pstm.setString(4, huesped.getNacionalidad());
				pstm.setString(5, huesped.getTelefono());
				pstm.setInt(6, huesped.getIdReserva());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						huesped.setId(rst.getInt(1));
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Metodo que Lista todos los huespedes registrados en la tabla huespedes de la base de datos 
	public List<Huespedes> listarHuespedes(){
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre, apellido, fechanacimiento,nacionalidad,telefono,idreserva FROM alurahotel.huespedes ORDER BY id";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Metodo que busca los Huespedes por ID
	 * Convierte el ID de String a int y utiliza PreparedStatement para realizar la consulta SQL.
	 * Transforma el ResultSet obtenido en una lista de objetos Huespedes.
	 */
	public List<Huespedes> buscarId(String id){
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre, apellido, fechanacimiento,nacionalidad,telefono,idreserva FROM alurahotel.huespedes WHERE id = ?";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)){
				 int idNumerico = Integer.parseInt(id);
				pstm.setInt(1, idNumerico);
				pstm.execute();
				
				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Metodo que busca los Huespedes por Apellido
	 * Utiliza PreparedStatement para realizar la consulta SQL y transforma el ResultSet en una lista de objetos Huespedes.
	 */
	public List<Huespedes> buscarApellido(String apellido){
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre, apellido, fechanacimiento,nacionalidad,telefono,idreserva FROM alurahotel.huespedes WHERE apellido = ?";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setString(1, apellido);
				pstm.execute();
				
				transformarResultSetEnHuesped(huespedes, pstm);
			}
			return huespedes;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Metodo para editar y Actualizar los Huespedes 
	 * Recibe los nuevos valores para los campos del huesped y el ID del registro a actualizar.
	 * Utiliza PreparedStatement para ejecutar la actualizacion SQL.
	 */
	public void actualizarHuesped(String nombre,String apellido, Date fechanacimiento, String nacionalidad,String telefono,Integer idreserva, Integer id) {
		try(PreparedStatement pstm =  connection.prepareStatement("UPDATE alurahotel.huespedes SET nombre = ?, apellido = ?, fechanacimiento = ?, nacionalidad = ?, telefono = ?, idreserva = ? WHERE id = ?")){
			pstm.setString(1, nombre);
			pstm.setString(2, apellido);
			pstm.setDate(3, fechanacimiento);
			pstm.setString(4, nacionalidad);
			pstm.setString(5, telefono);
			pstm.setInt(6, idreserva);
			pstm.setInt(7, id);
			pstm.execute();
		}catch(SQLException e ) {
			throw new RuntimeException(e);
		}
	}
	
	//Metodo para eliminar Huespedes de la base de datos por su ID.
	public void EliminarHuesped(Integer id) {
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM alurahotel.huespedes WHERE id = ?")){
			pstm.setInt(1, id);
			pstm.execute();
		}catch(SQLException e) {
			// Lanzamos una RuntimeException para evitar la necesidad de manejar o declarar SQLException.
			throw new RuntimeException(e);
		}
	}
	
	 // Método privado para convertir un ResultSet en una lista de objetos Huespedes.
	private void transformarResultSetEnHuesped(List<Huespedes> reservas,PreparedStatement pstm) throws SQLException {
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Huespedes huespedes = new Huespedes (rst.getInt(1), rst.getString(2), rst.getString(3),rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				reservas.add(huespedes);
			}
		}
	}
}
