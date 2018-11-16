package controlador;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import vista.AgendaInterface;

//Clase que se encarga del evento Cerrar
//public class ControladorVentana implements WindowListener {
//Window, mouse, key no tiene adaptadores
public class ControladorVentana extends WindowAdapter {
	
	private AgendaInterface vista;
	
	public ControladorVentana(AgendaInterface vista) {
		this.vista = vista;
	}
	
	public void windowClosing(WindowEvent e) {
		try {
			int opc = JOptionPane.showConfirmDialog((Component)vista, "DESEA GUARDAR LA INFORMACION.", "GUARDAR DATOS", JOptionPane.YES_NO_OPTION);
			if (opc == JOptionPane.YES_OPTION) {
				FileOutputStream file = new FileOutputStream("agenda.txt");
				ObjectOutputStream oos = new ObjectOutputStream(file);
				oos.writeObject(vista.getModelo());
				oos.close();
				file.close();
			}
			System.exit(0);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
