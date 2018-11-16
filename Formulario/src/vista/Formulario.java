package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBoton;
import modelo.Genero;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

public class Formulario extends JFrame implements FormularioInterface{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtContrasena;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnEnviar = new JButton("Enviar");
		panelBotones.add(btnEnviar);
		
		JButton btnSalir = new JButton("Salir");
		panelBotones.add(btnSalir);
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		panelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		panelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		panelPrincipal.add(lblGnero);
		
		JPanel panelGenero = new JPanel();
		panelPrincipal.add(panelGenero);
		panelGenero.setLayout(new BoxLayout(panelGenero, BoxLayout.Y_AXIS));
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setSelected(true);
		panelGenero.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		panelGenero.add(rdbtnMujer);
		
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(rdbtnMujer);
		grupoGenero.add(rdbtnHombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		panelPrincipal.add(lblContrasea);
		
		txtContrasena = new JPasswordField();
		panelPrincipal.add(txtContrasena);
		
		ControladorBoton controlador = new ControladorBoton(this);
		btnSalir.setActionCommand("SALIR");
		btnSalir.addActionListener(controlador);
		
		btnEnviar.setActionCommand("ENVIAR");
		btnEnviar.addActionListener(controlador);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return txtNombre.getText();
	}

	@Override
	public String getContrasena() {
		// TODO Auto-generated method stub
		return new String (txtContrasena.getPassword());
	}

	@Override
	public Genero getGenero() {
		// TODO Auto-generated method stub
		Genero genero = (rdbtnHombre.isSelected())?Genero.HOMBRE:Genero.MUJER;
		return genero;
	}

}
