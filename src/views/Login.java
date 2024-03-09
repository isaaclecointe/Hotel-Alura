package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.controller.LoginController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.FlowLayout;

public class Login extends JFrame {

	/**
	  * Clase Login, proporciona una interfaz gráfica para el inicio de sesión del usuario.
      * Incluye campos de texto para el usuario y la contraseña, y botones para acciones como realizar el login o salir de la aplicacion.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel lblAtras;

	/**
	 * Iniciar la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
     * Constructor que inicializa la ventana de inicio de sesión.
     * Configura el tamaño, el diseño y los componentes interactivos de la ventana.
     */
	public Login() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 788, 527);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(43, 166, 187));
		panel_1.setBounds(484, 0, 304, 527);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel btnexit = new JPanel();
		btnexit.setBounds(251, 0, 53, 36);
		panel_1.add(btnexit);
		
		JLabel imgHotel = new JLabel("");
		imgHotel.setBounds(0, 0, 304, 527);
		panel_1.add(imgHotel);
		imgHotel.setIcon(new ImageIcon("C:\\Users\\PC\\Documents\\proyecto hotel\\challenge-one-alura-hotel-latam-repositorio-base\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\20240220_125140_0000.png"));
		
		
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnexit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		labelExit = new JLabel("X");
		btnexit.add(labelExit);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);		
		
		// Campo de texto para el nombre de usuario y comportamiento del placeholder
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				// Al hacer clic en el campo, si el texto es el placeholder, se limpia el campo y se cambia el color del texto.
				 if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
					 txtUsuario.setText("");
					 txtUsuario.setForeground(Color.black);
			        }
				// Si el campo de contraseña está vacío, se rellena con el placeholder.
			        if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
			        	txtContrasena.setText("********");
			        	txtContrasena.setForeground(Color.gray);
			        }
			}
		});
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 256, 324, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 120, 215));
		separator.setBounds(65, 292, 324, 2);
		panel.add(separator);
		
		JLabel labelTitulo = new JLabel("INICIAR SESIÓN");
		labelTitulo.setForeground(new Color(14, 78, 184));
		labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		labelTitulo.setBounds(65, 149, 202, 26);
		panel.add(labelTitulo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(65, 393, 324, 2);
		panel.add(separator_1);
		
		// Configuración de JPasswordField para la contraseña con placeholder
		txtContrasena = new JPasswordField();
		txtContrasena.setText("********");
		txtContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				// Al hacer clic en el campo, si el texto es el placeholder, se limpia el campo y se cambia el color del texto.
				if (String.valueOf(txtContrasena.getPassword()).equals("********")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
		        }
				  // Si el campo de usuario está vacío, se rellena con el placeholder
		        if (txtUsuario.getText().isEmpty()) {
		        	txtUsuario.setText("Ingrese su nombre de usuario");
		        	txtUsuario.setText("");
		        	txtUsuario.setForeground(Color.gray);
		        }
			}
		});
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setBounds(65, 353, 324, 32);
		panel.add(txtContrasena);
		
		JLabel LabelUsuario = new JLabel("USUARIO");
		LabelUsuario.setForeground(SystemColor.textInactiveText);
		LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		LabelUsuario.setBounds(65, 219, 107, 26);
		panel.add(LabelUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setForeground(SystemColor.textInactiveText);
		lblContrasea.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblContrasea.setBounds(65, 316, 140, 26);
		panel.add(lblContrasea);
		
		//Boton Login contiene eventos para cambiar de color y para llamar al metodo Login cuando se hace click
		JPanel btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login();
			}
		});
		btnLogin.setBackground(new Color(5, 85, 182));
		btnLogin.setBounds(65, 431, 122, 44);
		panel.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel = new JLabel("ENTRAR");
		lblNewLabel.setBounds(0, 0, 122, 44);
		btnLogin.add(lblNewLabel);
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagenes/lOGO-50PX.png")));
		lblNewLabel_1.setBounds(65, 65, 48, 59);
		panel.add(lblNewLabel_1);
		
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
		header.setBackground(SystemColor.window);
		header.setBounds(0, 0, 784, 36);
		panel.add(header);
		header.setLayout(null);
		
		JPanel btnRegresar = new JPanel();
		btnRegresar.setBounds(0, 0, 53, 36);
		header.add(btnRegresar);
		btnRegresar.setBackground(new Color(255, 255, 255));
		btnRegresar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblAtras = new JLabel("<");
		btnRegresar.add(lblAtras);
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setForeground(new Color(0, 0, 0));

		//Boton para Regresar a la ventana anterior
		lblAtras.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal inicio = new MenuPrincipal();
				inicio.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			      btnRegresar.setBackground(Color.black);
			      lblAtras.setForeground(Color.white);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegresar.setBackground(Color.white);
				lblAtras.setForeground(Color.black);
			}
		});
	}
	
	// Metodo de login compara si los datos ingresados por el usuarios son validos. 
	private void Login() {
		 String usuario = txtUsuario.getText();
	     String contrasena = new String(txtContrasena.getPassword());

	    LoginController loginController = new LoginController();  

	    //Muestra la ventana Menu usuario si las credenciales son validas a traves de LoginController.
	        if(loginController.login(usuario, contrasena)){
	            MenuUsuario menu = new MenuUsuario();
	            menu.setVisible(true);
	            dispose();	 
	        }else {
	        	//si las credenciales no son validas.
	            JOptionPane.showMessageDialog(this, "Usuario o Contraseña no válidos");
	        }
	} 
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }//GEN-LAST:event_headerMousePressed

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
