package jdbc.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.modelo.Huespedes;
import jdbc.modelo.Reservas;

public class BusquedaController {

	private HuespedesController huespedesController;
	private ReservasController reservasController;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuespedesId;
	private DefaultTableModel modeloHuesped;
	private DefaultTableModel modeloReservas;
	private DefaultTableModel modeloHuespedesApellido;
	private DefaultTableModel modeloReservasApellido;
	
	
	
	public BusquedaController() {
		this.huespedesController = new HuespedesController();
		this.reservasController = new ReservasController();
		this.tbReservas = new JTable();
		this.tbHuespedes = new JTable();
		this.modelo = new DefaultTableModel();
		this.modeloHuespedesId = new DefaultTableModel();
		
       
	}
	
	public void setTablaHuespedes(JTable tablaHuespedes) {
	    this.tbHuespedes = tablaHuespedes;
	}
	
	public void setTablaReservas(JTable tablaReservas) {
	    this.tbReservas = tablaReservas;
	}
	
	public List<Reservas> BuscarReservas(){
		return this.reservasController.buscar();
	}
	
	public List<Reservas> BuscarReservasPorId(String txtBuscar){
		return this.reservasController.buscarPorId(txtBuscar);
	}
	
	public List<Reservas> BuscarReservasPorApellido(String txtBuscar){
		return this.reservasController.buscarPorApellido(txtBuscar);
	}
	
	public List<Huespedes> BuscarHuespedes(){
		return this.huespedesController.listaHuespedes();
	}
	
	public List<Huespedes> BuscarHuespedPorId(String txtBuscar){
		return this.huespedesController.buscarPorId(txtBuscar);
	}
	
	   private List<Huespedes> BuscarHuespedesPorApellido(String txtBuscar) {
			return this.huespedesController.buscarPorApellido(txtBuscar);
		}
	
	public void limpiarTabla() {
		((DefaultTableModel) tbHuespedes.getModel()).setColumnCount(0);
		((DefaultTableModel) tbReservas.getModel()).setColumnCount(0);
	}
	
	public void llenarTablaReservas() {
		
		List<Reservas> listaReservas = BuscarReservas();
		
		DefaultTableModel modeloReservas = new DefaultTableModel();
		
		try {                                                 //Creamos un modelo solo para llenar la tabla con todas las reservas
			
	    	   modeloReservas.addColumn("Numero Reserva");
	    	   modeloReservas.addColumn("Fecha entrada");
	    	   modeloReservas.addColumn("Fecha Salida");
	    	   modeloReservas.addColumn("Valor");
	    	   modeloReservas.addColumn("Forma Pago");
	    	   
			    for(Reservas reservas : listaReservas) {
			    	modeloReservas.addRow(new Object[] { reservas.getId(), reservas.getFechaEntrada(), reservas.getFechaSalida(), reservas.getValor(), reservas.getFormaPago() });
			    }
			    tbReservas.setModel(modeloReservas);  // asignamos el modelo a la tabla tbReservas
		}catch (Exception e) {
			throw e;
		}
	}

   public void llenarTablaReservasId(String txtBuscar) {
	   
	   List<Reservas> listaReservasId = BuscarReservasPorId(txtBuscar);
	   
	   if(listaReservasId.isEmpty()) {    //aqui hacemos lo mismo que en el metodo anterior solo que con un nombre de modelo diferente para evitar confusiones y hacemos una validacion para ver si el id 
		   JOptionPane.showMessageDialog(null, "No existe ninguna reserva ni huesped con ese id");    // ingresado existe si no devolvemos un mensaje de error
	   }else {                                                                                       
	    
	       try {
	    	   modelo = new DefaultTableModel();
	    	   
	    	   modelo.addColumn("Numero Reserva");
	    	   modelo.addColumn("Fecha entrada");
	    	   modelo.addColumn("Fecha Salida");
	    	   modelo.addColumn("Valor");
	    	   modelo.addColumn("Forma Pago");
	    	   for (Reservas reservas : listaReservasId) {
	    		   modelo.addRow(new Object[] { reservas.getId(), reservas.getFechaEntrada(), reservas.getFechaSalida(), reservas.getValor(), reservas.getFormaPago()});
	    	   }
	    	   tbReservas.setModel(modelo);
	       }catch (Exception e) {
	    	   throw e;
	       }
	   }
   }
   
   public void llenarTablaReservasPorApellido(String txtBuscar) {
		
		List<Reservas> listaReservasPorApellido = BuscarReservasPorApellido(txtBuscar);
		
		try {                                                 //Creamos un modelo solo para llenar la tabla con todas las reservas
			
	        modeloReservasApellido = new DefaultTableModel();
			
			modeloReservasApellido.addColumn("Numero Reserva");
			modeloReservasApellido.addColumn("Fecha entrada");
			modeloReservasApellido.addColumn("Fecha Salida");
			modeloReservasApellido.addColumn("Valor");
			modeloReservasApellido.addColumn("Forma Pago");
	    	   
			    for(Reservas reservas : listaReservasPorApellido) {
			    	modeloReservasApellido.addRow(new Object[] { reservas.getId(), reservas.getFechaEntrada(), reservas.getFechaSalida(), reservas.getValor(), reservas.getFormaPago() });
			    }
			    tbReservas.setModel(modeloReservasApellido);  // asignamos el modelo a la tabla tbReservas
		}catch (Exception e) {
			throw e;
		}
	}
   

public void llenarTablaHuespedes() {
		
		List<Huespedes> listaHuespedes = BuscarHuespedes();
		
		DefaultTableModel modeloHuespedes = new DefaultTableModel();
		
		try {                                             // aqui el mismo proceso un nuevo modelo para traer todos los huespedes  a 
           
			                       //la tabla huespedes se crean nuevos modelo en cada metodo para evitar que se mezclen los resultados entre las tablas huespedes y reservas
			modeloHuespedes.addColumn("Número de Huesped");
			modeloHuespedes.addColumn("Nombre");
			modeloHuespedes.addColumn("Apellido");
			modeloHuespedes.addColumn("Fecha de Nacimiento");
			modeloHuespedes.addColumn("Nacionalidad");
			modeloHuespedes.addColumn("Telefono");
			modeloHuespedes.addColumn("Número de Reserva");
			
			    for(Huespedes huespedes : listaHuespedes) {
			    	modeloHuespedes.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(), huespedes.getApellido(),huespedes.getFechaNacimiento(), huespedes.getNacionalidad(), huespedes.getTelefono(), huespedes.getIdReserva() });
			    }
			    tbHuespedes.setModel(modeloHuespedes);
		}catch (Exception e) {
			throw e;
		}
	}   
   
   public void llenarTablaHuespedesId(String txtBuscar) {
		
		List<Huespedes> listaHuespedesId = BuscarHuespedPorId(txtBuscar);
		try {                                                            //mismo proceso al segundo metodo siempre cambiando el nombre del modelo
			modeloHuespedesId = new DefaultTableModel();                   // para que no genere ningun conflicto
			
			modeloHuespedesId.addColumn("Número de Huesped");
			modeloHuespedesId.addColumn("Nombre");
			modeloHuespedesId.addColumn("Apellido");
			modeloHuespedesId.addColumn("Fecha de Nacimiento");
			modeloHuespedesId.addColumn("Nacionalidad");
			modeloHuespedesId.addColumn("Telefono");
			modeloHuespedesId.addColumn("Número de Reserva");
			    for(Huespedes huespedes : listaHuespedesId) {
			    	modeloHuespedesId.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(), huespedes.getApellido(),huespedes.getFechaNacimiento(), huespedes.getNacionalidad(), huespedes.getTelefono(), huespedes.getIdReserva() });
			    }
			    tbHuespedes.setModel(modeloHuespedesId);
		}catch (Exception e) {
			throw e;
		}
	}   


   public void llenarTablaHuespedesApellido(String txtBuscar) {
		
 		List<Huespedes> listaHuespedesPorApellido = BuscarHuespedesPorApellido(txtBuscar);
 		try {                                                            //mismo proceso al segundo metodo siempre cambiando el nombre del modelo
 			modeloHuespedesApellido = new DefaultTableModel();                   // para que no genere ningun conflicto
 			
 			modeloHuespedesApellido.addColumn("Número de Huesped");
 			modeloHuespedesApellido.addColumn("Nombre");
 			modeloHuespedesApellido.addColumn("Apellido");
 			modeloHuespedesApellido.addColumn("Fecha de Nacimiento");
 			modeloHuespedesApellido.addColumn("Nacionalidad");
 			modeloHuespedesApellido.addColumn("Telefono");
 			modeloHuespedesApellido.addColumn("Número de Reserva");
 			    for(Huespedes huespedes : listaHuespedesPorApellido) {
 			    	modeloHuespedesApellido.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(), huespedes.getApellido(),huespedes.getFechaNacimiento(), huespedes.getNacionalidad(), huespedes.getTelefono(), huespedes.getIdReserva() });
 			    }
 			    tbHuespedes.setModel(modeloHuespedesApellido);
 		}catch (Exception e) {
 			throw e;
 		}
 	}  
   
   
   public void ActualizarReservas() {
	   Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(),tbReservas.convertColumnIndexToModel(tbReservas.getSelectedColumn())))
	   .or(() -> Optional.ofNullable(modeloReservas.getValueAt(tbReservas.getSelectedRow(),tbReservas.convertColumnIndexToModel(tbReservas.getSelectedColumn()))))
	   .ifPresentOrElse(fila ->{
		   Date fechaentrada = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
		   Date fechasalida = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
		   String valor = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString();
		   String formapago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4).toString();
		   Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
		   this.reservasController.actualizar(fechaentrada, fechasalida, valor, formapago, id);
		   JOptionPane.showMessageDialog(null, String.format("Registro Actualizado correctamente"));
	 },()->JOptionPane.showMessageDialog(null, "Debe elejir primero un registro porfavor"));
   }
   
   public void ActualizarHuespedes() {
	   Optional.ofNullable(modeloHuespedesId.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.convertColumnIndexToModel(tbHuespedes.getSelectedColumn())))
	   .or(() -> Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),tbHuespedes.convertColumnIndexToModel(tbHuespedes.getSelectedColumn()))))
	   .ifPresentOrElse(filaHuespedes -> {
		   String nombre = (String) modeloHuespedesId.getValueAt(tbHuespedes.getSelectedRow(), 1);
		   String apellido = (String) modeloHuespedesId.getValueAt(tbHuespedes.getSelectedRow(), 2);
		   Date fechanacimiento = Date.valueOf(modeloHuespedesId.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
		   String nacionalidad = (String) modeloHuespedesId.getValueAt(tbHuespedes.getSelectedRow(), 4);
		   String telefono = (String) modeloHuespedesId.getValueAt(tbHuespedes.getSelectedRow(), 5);
		   Integer idReserva = Integer.valueOf(modeloHuespedesId.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());
		   Integer id = Integer.valueOf(modeloHuespedesId.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
		   
		   if(tbHuespedes.getSelectedColumn() == 0 || tbHuespedes.getSelectedColumn() == 6) {
			   JOptionPane.showMessageDialog(null, "No se pueden modificar los id");
		   }else {
		   this.huespedesController.actualizar(nombre, apellido, fechanacimiento, nacionalidad, telefono, idReserva, id);
		   JOptionPane.showMessageDialog(null, String.format("Registro Actualizado correctamente"));
		   }
		   
	},() -> JOptionPane.showMessageDialog(null, "Debe elejir primero un registro porfavor")) ;
	   
   }


public DefaultTableModel getModeloHuespedesApellido() {
	return modeloHuespedesApellido;
}

public void setModeloHuespedesApellido(DefaultTableModel modeloHuespedesApellido) {
	this.modeloHuespedesApellido = modeloHuespedesApellido;
}

public DefaultTableModel getModeloReservasApellido() {
	return modeloReservasApellido;
}

public void setModeloReservasApellido(DefaultTableModel modeloReservasApellido) {
	this.modeloReservasApellido = modeloReservasApellido;
}
   
}
