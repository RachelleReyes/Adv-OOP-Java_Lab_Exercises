package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import modelo.Genero;
import modelo.Persona;

public class PersonaPanel extends JPanel{
	private JTextField txtNombre;
	private JFormattedTextField txtEdad;
	private JFormattedTextField txtTelefono;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JFormattedTextField txtCorreo;
	
	public PersonaPanel() throws ParseException {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 4, true), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		add(lblNombre);
		
		txtNombre = new JTextField();
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		add(lblEdad);
		
		/*
		NumberFormat formatoNumero = NumberFormat.getIntegerInstance();
		formatoNumero.setMinimumIntegerDigits(1);
		formatoNumero.setMaximumIntegerDigits(3);
		*/
		
		MaskFormatter formatoNumero = new MaskFormatter("###");
		txtEdad = new JFormattedTextField(formatoNumero);
		//JFormattedTextField txtEdad = new JFormattedTextField(new Integer(0));
		add(txtEdad);
		
		JLabel lblGenero = new JLabel("Genero");
		add(lblGenero);
		
		JPanel panelGenero = new JPanel();
		add(panelGenero);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		panelGenero.add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino");
		panelGenero.add(rdbtnFemenino);
		
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(rdbtnFemenino);
		grupoGenero.add(rdbtnMasculino);
		rdbtnMasculino.setSelected(true);
		
		JLabel lblTelefono = new JLabel("Telefono");
		add(lblTelefono);
		
		MaskFormatter telefonoFormato = new MaskFormatter("(###)###-####");
		txtTelefono = new JFormattedTextField(telefonoFormato);
		add(txtTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		add(lblCorreo);
		
		//Patrones, Automatas para validar
		txtCorreo = new JFormattedTextField();
		add(txtCorreo);
		
	}
	
	public void setDatos(Persona p) {
		txtNombre.setText(p.getNombre());
		txtTelefono.setText(p.getTelefono());
		txtEdad.setText(String.valueOf(p.getEdad()));
		txtCorreo.setText(p.getCorreo());
		if(p.getGenero()==Genero.MASCULINO) 
			rdbtnMasculino.setSelected(true);
		else 
			rdbtnFemenino.setSelected(true);
	}
	
}
