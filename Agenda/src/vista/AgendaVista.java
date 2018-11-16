package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorLista;
import modelo.Genero;
import modelo.Persona;

public class AgendaVista extends JFrame implements AgendaInterface {

	private JPanel contentPane;
	private DefaultListModel<Persona>modelo;
	private PersonaPanel personaPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaVista frame = new AgendaVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AgendaVista() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnNuevo = new JButton("Nuevo");
		panelBotones.add(btnNuevo);
		
		JButton btnAgregar = new JButton("Agregar");
		panelBotones.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		panelBotones.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		panelBotones.add(btnEliminar);
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.X_AXIS));
		
		personaPanel = new PersonaPanel();
		panelPrincipal.add(personaPanel);
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPrincipal.add(panelResultados);
		panelResultados.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelResultados.add(scrollPane, BorderLayout.CENTER);
		
		JList listaResultados = new JList();
		scrollPane.setViewportView(listaResultados);
		
		modelo = new DefaultListModel<Persona>();
		listaResultados.setModel(modelo);
		
		Persona p = new Persona("Rachelle", 21, "12123","12123", Genero.FEMENINO);
		Persona p2 = new Persona("Nerie", 21, "12123","12123", Genero.FEMENINO);
		Persona p3 = new Persona("Ruchelle", 25, "12123","12123", Genero.FEMENINO);
		
		modelo.addElement(p);
		modelo.addElement(p2);
		modelo.addElement(p3);
		
		listaResultados.addListSelectionListener(new ControladorLista(this));
	}

	@Override
	public void setPersona(Persona p) {
		// TODO Auto-generated method stub
		personaPanel.setDatos(p);
		
	}

}
