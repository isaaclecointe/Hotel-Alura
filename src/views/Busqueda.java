package views;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jdbc.controller.BusquedaController;
import jdbc.controller.HuespedesController;
import jdbc.controller.ReservasController;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;



/**
 * Clase Busqueda que extiende de JFrame, proporcionando una interfaz gráfica para la búsqueda de reservas y huéspedes.
 * Incluye campos de texto, tablas y componentes para la interaccion con la información del hotel.
 */

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private ReservasController reservasController;
	private HuespedesController huespedesController;
	private BusquedaController busquedaController;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	String reservas;
	String huespedes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		this.reservasController = new ReservasController();
		this.huespedesController = new HuespedesController();
		this.busquedaController = new BusquedaController();
        busquedaController.setTablaHuespedes(tbHuespedes);
        busquedaController.setTablaReservas(tbReservas);
        new DefaultTableModel();
        new DefaultTableModel();

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		// Crear un modelo local
		DefaultTableModel modeloLocal = (DefaultTableModel) tbReservas.getModel();
		modeloLocal.addColumn("Numero de Reserva");
		modeloLocal.addColumn("Fecha Check In");
		modeloLocal.addColumn("Fecha Check Out");
		modeloLocal.addColumn("Valor");
		modeloLocal.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		busquedaController.setTablaReservas(tbReservas);
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		DefaultTableModel modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		busquedaController.setTablaHuespedes(tbHuespedes);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		/**
		 * Evento al hacer clic: Regresa al menú de usuario.
		 * Si el usuario hace clic, se redirige a la ventana del Menú de Usuario.
		 */
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();			
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}		
			
			
			 // Evento al salir del botón: Restaura los colores originales.
			 

			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		
		
		
		
		/**
		 * Evento al hacer clic: Regresa al menú de usuario.
		 * Si el usuario hace clic, se redirige a la ventana del Menú de Usuario.
		 */

		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			
			//Al usuario pasar el cursor por el botón este cambiará de color
			@Override
			public void mouseEntered(MouseEvent e) { 
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			

			
			
			//  Evento al salir del botón: Restaura los colores originales.
			 
			
			@Override
			public void mouseExited(MouseEvent e) { 
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		/**
		 * JPanel evento al hacer click en el boton de buscar
		 * Obtiene el texto ingresado en el campo de búsqueda "txtBuscar" 
		 * y realiza búsquedas correspondientes.
		 */
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Obtener  el texto del campo de busqueda
				String id = txtBuscar.getText();
				
			//Verificar  si el campo de busqueda esta vacio
			if(id == null || id.isEmpty()) { 
				// Si esta vacio, llenar las tablas con todos los registros 
			    busquedaController.llenarTablaReservas();
			    busquedaController.llenarTablaHuespedes(); 
			}else{
				try {
					//Si se ingreso un ID, realizar la busqueda por ID
			 busquedaController.llenarTablaReservasId(id);  
			 busquedaController.llenarTablaHuespedesId(id); 
		}catch (NumberFormatException ex) {
			//Si se ingresa un apellido, manejar la excepcion y buscar por apellido 
			busquedaController.llenarTablaHuespedesApellido(id);
			busquedaController.llenarTablaReservasPorApellido(id);
		}
			}
			    }		
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(Color.WHITE);
		btnbuscar.setBounds(733, 127, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.setBounds(0, 0, 63, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBuscar.setIcon(new ImageIcon("C:\\Users\\PC\\Documents\\proyecto hotel\\challenge-one-alura-hotel-latam-repositorio-base\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\lupa2.png"));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		/**
		 * JPanel evento al hacer click en el boton editar 
		 * Obtiene el indice de la fila seleccionada de la tabla 
		 */
		
		JPanel btnEditar = new JPanel();
		btnEditar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Obtner el indice de la fila seleccionada 
				int filaReservas = tbReservas.getSelectedRow();
				int filaHuespedes = tbHuespedes.getSelectedRow();
				
				
				// codigo si se selecciona  una fila de la tabla Reservas
				if(filaReservas >= 0) {
					busquedaController.ActualizarReservas();
					busquedaController.limpiarTabla();
					busquedaController.llenarTablaReservas();
					busquedaController.llenarTablaHuespedes();
				}
				
				// codigo si se selecciona una fila de la tabla Huespedes
				else if (filaHuespedes >= 0) {
					busquedaController.ActualizarHuespedes();
					busquedaController.limpiarTabla();
					busquedaController.llenarTablaHuespedes();
					busquedaController.llenarTablaReservas();
				}
			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(622, 508, 135, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("  EDITAR");
		lblEditar.setIcon(new ImageIcon("C:\\Users\\PC\\Documents\\proyecto hotel\\challenge-one-alura-hotel-latam-repositorio-base\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\editar-texto.png"));
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(new Color(119, 101, 224));
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 135, 35);
		btnEditar.add(lblEditar);
		
		
		/**
		 * JPanel evento al hacer click elimina el registro seleccionado
		 * de la tabla correspondiente 
		 */
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnEliminar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// Obtiene el indice de la fila seleccionada 
				int filaReservas = tbReservas.getSelectedRow();
				int filaHuespedes = tbHuespedes.getSelectedRow();
				
				//Si se selecciono una fila de la tabla reservas   
				if(filaReservas >= 0) {
					reservas = tbReservas.getValueAt(filaReservas, 0).toString();
					int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres eliminar los datos?");
					
					if(confirmar == JOptionPane.YES_OPTION) {
						//extrae el valor de la primera columna de la fila seleccionada en la tabla y lo almacena como una cadena en la variable
						String valor = tbReservas.getValueAt(filaReservas, 0).toString();
						reservasController.Eliminar(Integer.valueOf(valor));  // se elimina la reserva
						JOptionPane.showMessageDialog(contentPane, "Registro Eliminado");
						 // limpiar y llenar
						busquedaController.limpiarTabla();
						busquedaController.llenarTablaReservas();
						busquedaController.llenarTablaHuespedes();
					}
				}
				
				//Si se selecciona una fila de la tabla Huespedes
				else if (filaHuespedes >= 0) {
					huespedes = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
					int confirmarhuesped = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres eliminar los datos?");
					
					if(confirmarhuesped == JOptionPane.YES_OPTION) {
						
						//extrae el valor de la primera columna de la fila seleccionada en la tabla  y lo almacena como una cadena en la variable
						String valorHuesped = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
						huespedesController.Eliminar(Integer.valueOf(valorHuesped));   //  se elimina el huesped
						JOptionPane.showMessageDialog(contentPane, "Registro eliminado");
						 // limpiar y llenar
						busquedaController.limpiarTabla();               
						busquedaController.llenarTablaHuespedes();
						busquedaController.llenarTablaReservas();
					}
				}
				
				//Si ocurre algo distinto a los otros 2 bloques 
				else {
					JOptionPane.showMessageDialog(null, "Ups, Ocurrio un error fila no seleccionada, porfavor seleccione una fila para eliminarla");
				}
			}
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("");
		lblEliminar.setIcon(new ImageIcon("C:\\Users\\PC\\Documents\\proyecto hotel\\challenge-one-alura-hotel-latam-repositorio-base\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\deletar.png"));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(119, 101, 224));
		separator_1_2_1.setBounds(584, 554, 173, 2);
		contentPane.add(separator_1_2_1);
		setResizable(false);
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
