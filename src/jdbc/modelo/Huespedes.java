package jdbc.modelo;

import java.sql.Date;

/**
 * Clase que representa el modelo de un huesped en el sistema del hotel.
 * Contiene informacion personal y de reservas del huesped.
 */

public class Huespedes {
	
	//Campos privados que representan las propiedades de un huesped.
	
    private Integer Id;
    private String Nombre;
    private String Apellido;
    private Date FechaNacimiento;
    private String Nacionalidad;
    private String Telefono;
    private Integer IdReserva;
    
    
    // Constructor para crear un objeto Huespedes sin ID.
    
    public Huespedes( String nombre,String apellido,Date fechaNacimiento,String nacionalidad,String telefono,Integer idReserva) {
    	super();
    	Nombre = nombre;
    	Apellido = apellido;
    	FechaNacimiento = fechaNacimiento;
    	Nacionalidad = nacionalidad;
    	Telefono = telefono;
    	IdReserva = idReserva;
    }
    
    //Constructor para crear un objeto huespedes con ID
    public Huespedes(Integer id, String nombre,String apellido,Date fechaNacimiento,String nacionalidad,String telefono,Integer idReserva) {
    	super();
    	Id = id ;
    	Nombre = nombre;
    	Apellido = apellido;
    	FechaNacimiento = fechaNacimiento;
    	Nacionalidad = nacionalidad;
    	Telefono = telefono;
    	IdReserva = idReserva;
    }
    
    //Metodos getters y setter para acceder y modificar las propiedades del huesped.
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public Integer getIdReserva() {
		return IdReserva;
	}
	public void setIdReserva(Integer idReserva) {
		IdReserva = idReserva;
	}
    
    
}
