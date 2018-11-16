package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.FormularioInterface;

public class ControladorBoton implements ActionListener {
	private FormularioInterface vista;
	
	public ControladorBoton(FormularioInterface vista) {
		this.vista = vista;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		switch(comando) {
		case "SALIR": 
			int opcion = JOptionPane.showConfirmDialog((Component) vista, "Seguro que quieres salir", "SALIR", JOptionPane.YES_NO_OPTION);
			if(opcion==JOptionPane.YES_OPTION)
				System.exit(0);
			break;
		case "ENVIAR": 
			String mensaje = "Nombre: " + vista.getNombre() + "\nContraseña: " + vista.getContrasena() + "\nGenero: " + vista.getGenero().toString();
			if(vista.getNombre().isEmpty()) {  
				JOptionPane.showMessageDialog((Component)vista, "Error. Nombre incompleto", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog((Component)vista, mensaje, "Datos", JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		}
	}

}
