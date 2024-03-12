package jdbc.controller;

import java.sql.Connection;


import java.sql.Date;
import java.util.List;

import jdbc.dao.HuespedesDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Huespedes;

    /**
     * Clase controladora para la gestion de los huespedes en la base de datos.
     * Esta clase proporciona metodos para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) 
     * sobre la entidad Huespedes y utiliza huespedes DAO para la interaccion con la base de datos.
     */

public class HuespedesController {
	private HuespedesDAO huespedesDAO;
	
	
	// Constructor que establece la conexion con la base de datos  y inicializa HuespedesDAO
	public HuespedesController() {
		   Connection connection = new ConnectionFactory().recuperaConexion();
		   this.huespedesDAO = new  HuespedesDAO(connection);
	}
	
	/**
	 * Metodos para Guardar, Listar todos los Huespedes,
	 * Buscar por ID, buscar por Apellido, Actualizar y Eliminar.
	 * A través de la clase HuespedesDAO.
	 */
	
	public void guardar (Huespedes huesped) {
		this.huespedesDAO.guardarHuesped(huesped);
	}
	
	public List<Huespedes>listaHuespedes(){
		return this.huespedesDAO.listarHuespedes();
	}

	public List<Huespedes> buscarPorId(String id){
		return this.huespedesDAO.buscarId(id);
	}
	
	public void actualizar(String nombre,String apellido, Date fechanacimiento, String nacionalidad,String telefono,Integer idreserva, Integer id) {
		 this.huespedesDAO.actualizarHuesped(nombre, apellido, fechanacimiento, nacionalidad, telefono, idreserva, id);
	}
	
	public void Eliminar(Integer id) {
		this.huespedesDAO.EliminarHuesped(id);
	}
	
	public List<Huespedes> buscarPorApellido(String apellido){
		return this.huespedesDAO.buscarApellido(apellido);
	}
}
