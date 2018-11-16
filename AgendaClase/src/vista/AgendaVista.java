package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorBoton;
import controlador.ControladorLista;
import controlador.ControladorVentana;
import modelo.Persona;

public class AgendaVista extends JFrame implements AgendaInterface{

	private JPanel contentPane;
	private DefaultListModel<Persona> modelo;
	private PersonaPanel personaPanel;
	private JList listaResultados;

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
		setBounds(100, 100, 574, 301);
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
		panelResultados.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 5, true), "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPrincipal.add(panelResultados);
		panelResultados.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelResultados.add(scrollPane, BorderLayout.CENTER);
		
		listaResultados = new JList();
		listaResultados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaResultados);
		
		try {
			FileInputStream file = new FileInputStream("agenda.txt");
			ObjectInputStream ois = new ObjectInputStream(file);
			modelo = (DefaultListModel<Persona>) ois.readObject();
			ois.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			modelo=new DefaultListModel<Persona>(); //Si el archivo no existe
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //add catch clause
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listaResultados.setModel(modelo);
		
		/*
		Persona p=new Persona("Juan", 23, "12123","12321",Genero.MASCULINO);
		Persona p2=new Persona("Maria", 23, "12123","12321",Genero.FEMENINO);
		Persona p3=new Persona("Pedro", 23, "12123","12321",Genero.MASCULINO);
		
		modelo.addElement(p);
		modelo.addElement(p2);
		modelo.addElement(p3);
		*/
		listaResultados.addListSelectionListener(new ControladorLista(this));
		
		ControladorBoton controlador = new ControladorBoton(this);
		btnAgregar.setActionCommand("AGREGAR");
		btnAgregar.addActionListener(controlador);
		
		btnNuevo.setActionCommand("NUEVO");
		btnNuevo.addActionListener(controlador);
		
		btnEditar.setActionCommand("EDITAR");
		btnEditar.addActionListener(controlador);
		
		btnEliminar.setActionCommand("ELIMINAR");
		btnEliminar.addActionListener(controlador);
		
		addWindowListener(new ControladorVentana(this));
		
	}

	@Override
	public void setPersona(Persona p) {
		// TODO Auto-generated method stub
		personaPanel.setDatos(p);
		
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		personaPanel.limpiarDatos();
		listaResultados.clearSelection();
	}

	@Override
	public Persona getPersona() {
		// TODO Auto-generated method stub
		return personaPanel.getPersona();
	}

	@Override
	public int getIndice() {
		// TODO Auto-generated method stub
		return listaResultados.getSelectedIndex();
	}

	@Override
	public DefaultListModel<Persona> getModelo() {
		// TODO Auto-generated method stub
		return modelo;
	}
	
}
