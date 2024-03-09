package jdbc.dao;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Reservas;


    /**
     * DAO clase para manejar las operaciones de la base de datos relacionadas con las reservas del hotel.
     * permite insertar, buscar, actualizar y eliminar reservas en la base de datos.
     * 
     */

public class ReservasDAO {

	private Connection connection;
	
	public  ReservasDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	/**
	 * Metodo para insertar una nueva Reserva en la base de datos
	 * Retorna el ID auto generado y lo asigna a la reserva.
	 */
	public void guardarReserva(Reservas reserva)  {
		
		try {
		String sql = "INSERT INTO alurahotel.reservas (fechaentrada, fechasalida, valor, formaPago) VALUES (?,?,?,?)";
		try(PreparedStatement statement  = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
		
			statement.setDate(1, reserva.getFechaEntrada());
			statement.setDate(2, reserva.getFechaSalida());
			statement.setString(3, reserva.getValor());
			statement.setString(4, reserva.getFormaPago());
			
			statement.executeUpdate();
			
			try(ResultSet rst = statement.getGeneratedKeys()){
				while(rst.next()) {
					reserva.setId(rst.getInt(1));
				}
			}
		}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Metodo que busca todas las Reservas que existan en la base de datos y las devuelve en una lista.
	public List<Reservas> buscarReservas(){
		List<Reservas> reservas = new ArrayList<>();
		String sql = "SELECT id, fechaentrada, fechasalida, valor, formaPago FROM alurahotel.reservas ORDER BY id";
		try(Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)){
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				Date fechaE = resultSet.getDate("fechaentrada");
				Date fechaS = resultSet.getDate("fechasalida");
				String valor = resultSet.getString("valor");
				String formaPago = resultSet.getString("formaPago");
				Reservas reserva = new Reservas(id, fechaE, fechaS, valor, formaPago);
				reservas.add(reserva);
			}
			
		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
		return reservas;
	}
	
	
	//Metodo que busca las reservas Por su ID y devuelve una lista que contiene la reserva encontrada.
	public List<Reservas> buscarReservaPorId(String id) {
	     List<Reservas> reservas = new ArrayList<Reservas>();
	     try {
	    	 String sql = "SELECT id, fechaentrada, fechasalida, valor, formapago FROM alurahotel.reservas WHERE id = ?";
	    	 
	    	 try (PreparedStatement pstm = connection.prepareStatement(sql)){
	    		 int idNumerico = Integer.parseInt(id);
	    		 pstm.setInt(1, idNumerico);
	    		 pstm.execute();
	    		 
	    		 transformarResultSetEnReserva(reservas,pstm);
	    	 }
	    	 return reservas;
	     }catch(SQLException e) {
	    	 throw new RuntimeException(e);
	     }
	}
	
	//Metodo que busca por el Apellido 
	public List<Reservas> buscarReservaPorApellido(String apellido){
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {
			String sql = "SELECT id, fechaentrada, fechasalida, valor, formapago " + "FROM alurahotel.reservas " + 
		    "WHERE id IN(SELECT id FROM alurahotel.huespedes WHERE apellido = ?)";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setString(1, apellido);
				pstm.execute();
				
				transformarResultSetEnReserva(reservas, pstm);
			}
			return reservas;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Metodo que elimina la Reserva  de la base de datos por su ID.
	public void Eliminar(Integer id) {
		try(PreparedStatement pst = connection.prepareStatement("DELETE FROM alurahotel.reservas WHERE id = ?")){
			pst.setInt(1, id);
			pst.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Metodo para actualizar la reserva
	 * @param fechaentrada La nueva fecha de entrada
	 * @param fechasalida La nueva fecha de salida 
	 * @param valor El nuevo valor de la reserva 
	 * @param formapago La nueva forma de pago
	 * @param id El id de la reserva a acttualizar 
	 */
	public void Actualizar(Date fechaentrada, Date fechasalida, String valor, String formapago, Integer id ) {
		try(PreparedStatement pst = connection.prepareStatement("UPDATE alurahotel.reservas SET fechaentrada = ?, fechasalida = ?, valor = ?, formapago = ? WHERE id = ? ")){
			pst.setDate(1, fechaentrada);
			pst.setDate(2, fechasalida);
			pst.setString(3, valor);
			pst.setString(4, formapago);
			pst.setInt(5, id);
			pst.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
   
	
	/**
	 *  Método privado para convertir un ResultSet en una lista de objetos Reservas.
	 * @param reservas La lista donde se almacenaran las reservas
	 * @param pstm El PreparedStatement que contiene el ResultSet a transformar.
	 * @throws SQLException Si ocurre un error al acceder al ResultSet.
	 */
	
	private void transformarResultSetEnReserva(List<Reservas> reservas, PreparedStatement pstm) throws SQLException {
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Reservas producto = new Reservas(rst.getInt("id"), rst.getDate("fechaentrada"), rst.getDate("fechasalida"), rst.getString("valor"),rst.getString("formapago"));
				
				reservas.add(producto);
			}
		}
		
	}
}
