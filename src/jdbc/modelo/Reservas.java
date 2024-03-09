package jdbc.modelo;

import java.sql.Date;


/**
 * Clase que representa el modelo de una Reserva en el sistema del hotel.
 * Contiene informacion sobre el estado de la reservas del huesped.
 */
public class Reservas {

    // Campos privados que representan las propiedades de una Reserva
	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String valor;
	private String formaPago;
	 
	
	//Constructor para crear objeto Reservas sin un ID asignado.
	public Reservas(Date fechaEntrada, Date fechaSalida, String valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	
     /** 
      * Constructor para crear una reserva con un ID.
      * Se utiliza cuando la reserva ha sido recuperada de la base de datos y ya tiene un ID.
      * 
      */
 
	public Reservas(Integer id, Date fechaEntrada, Date fechaSalida, String valor, String formaPago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	//Metodos getters y setter para acceder y modificar las propiedades de la Reserva.
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public String getValor() {
		return valor;
	}

	public String getFormaPago() {
		return formaPago;
	}
	
	
}
