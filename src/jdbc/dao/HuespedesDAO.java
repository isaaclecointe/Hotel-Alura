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

public class HuespedesDAO {

	private Connection connection;
	
	public HuespedesDAO(Connection connection) {
		this.connection = connection;
	}
	
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
	
	public void EliminarHuesped(Integer id) {
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM alurahotel.huespedes WHERE id = ?")){
			pstm.setInt(1, id);
			pstm.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private void transformarResultSetEnHuesped(List<Huespedes> reservas,PreparedStatement pstm) throws SQLException {
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Huespedes huespedes = new Huespedes (rst.getInt(1), rst.getString(2), rst.getString(3),rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				reservas.add(huespedes);
			}
		}
	}
}
