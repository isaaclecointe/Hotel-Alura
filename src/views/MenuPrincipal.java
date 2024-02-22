package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		
		Panel panel = new Panel();
		panel.setForeground(new Color(43, 166, 187));
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 910, 537);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(-50, 0, 732, 501);
		imagenFondo.setIcon(new ImageIcon("C:\\Users\\PC\\Documents\\proyecto hotel\\challenge-one-alura-hotel-latam-repositorio-base\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\20240220_125043_0003.png"));
		panel.add(imagenFondo);
		
		JLabel logo = new JLabel("");
		logo.setBounds(722, 80, 150, 156);
		logo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/aH-150px.png")));
		panel.add(logo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 500, 910, 37);
		panel_1.setBackground(new Color(43, 166, 187));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCopyR = new JLabel("Desarrollado por Isaac Lecointe © 2024");
		lblCopyR.setBounds(315, 11, 284, 19);
		lblCopyR.setForeground(new Color(240, 248, 255));
		lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel_1.add(lblCopyR);
		
		//Barra para controlar la ventana 
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		panel.add(header);
		
		
		
		/*
		 * Botón Login
		 * se usa el evento mouseClicked  
		 * se crea una variable login donde se almancena la ventana de Login
		 * si se hace un click se muestra la siguiente ventana usando login.setVisible(true); dispose();
		 * 
		 */
		JPanel btnLogin = new JPanel(); 
		btnLogin.setBounds(754, 300, 83, 70);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setBackground(SystemColor.window);
		panel.add(btnLogin);
		
		JLabel imagenLogin = new JLabel("");
		imagenLogin.setBounds(0, 0, 80, 70);
		btnLogin.add(imagenLogin);
		imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
		imagenLogin.setIcon(new ImageIcon("C:\\Users\\PC\\Documents\\proyecto hotel\\challenge-one-alura-hotel-latam-repositorio-base\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\20240220_125245_0000.png"));
		
		JLabel lblTitulo = new JLabel("LOGIN");
		lblTitulo.setBounds(754, 265, 83, 24);
		lblTitulo.setBackground(SystemColor.window);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(43, 166, 187));
		lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));
		
		
		
		/*   Boton para salir  se utiliza el evento mouseclicked 
		 *   se crea una variable opcion donde almacena el mensaje  de confirmacion
		 *   JOptionPane.YES_NO_OPTION
		 *   se usa un if para comparar si opcion es igual a la respuesta elejida
		 *   si es si se cierra la aiplicacion  si no else regresar a donde estaba 
		 */
		
		JPanel BtnSalida = new JPanel();
		BtnSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas salir de la aplicacion", "Confirmar salida",
						JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_NO_OPTION) {
					System.exit(0);  // si se cierrra la aplicacion 
                   
				}else {
					// no se cierra la aplicacion 
				}
			}
		});
		BtnSalida.setBorder(null);
		BtnSalida.setBackground(Color.WHITE);
		BtnSalida.setBounds(823, 410, 74, 79);
		panel.add(BtnSalida);
		BtnSalida.setLayout(null);
		BtnSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 64, 64);
		BtnSalida.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\Documents\\proyecto hotel\\challenge-one-alura-hotel-latam-repositorio-base\\challenge-one-alura-hotel-latam-repositorio-base\\src\\imagenes\\20240220_125245_0001.png"));
	}
	
	//Código que permite movimentar a janela pela tela seguindo a posição de "x" e "y"	
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

