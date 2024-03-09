package jdbc.controller;

import java.sql.Connection;

import java.sql.Date;
import java.util.List;

import jdbc.dao.ReservasDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reservas;



public class ReservasController {

	private ReservasDAO reservasDAO;
	
	// Constructor que establece la conexion con la base de datos  y inicializa ReservasDAO
	public ReservasController() {
		Connection connection = new ConnectionFactory().recuperaConexion();
		this.reservasDAO = new ReservasDAO(connection);
	}
	
	/**
	 * Metodos para Guardar, Listar todas las Reservas,
	 * Buscar por ID, buscar por Apellido, Actualizar y Eliminar.
	 * A través de la clase HuespedesDAO.
	 */
	
	public void guardar(Reservas reservas) {
		this.reservasDAO.guardarReserva(reservas);
	}
	
	public List<Reservas> buscar(){
		return this.reservasDAO.buscarReservas();
	}
	
	public List<Reservas>buscarPorId(String id){
		return this.reservasDAO.buscarReservaPorId(id);
	}

     public void actualizar (Date fechaentrada, Date fechasalida, String valor, String formapago, Integer id ) {
    	 this.reservasDAO.Actualizar(fechaentrada, fechasalida, valor, formapago, id);
     }
     
     public void Eliminar(Integer id) {
    	 this.reservasDAO.Eliminar(id);
     }
     
     public List<Reservas> buscarPorApellido(String apellido){
 		return this.reservasDAO.buscarReservaPorApellido(apellido);
 	}
}
