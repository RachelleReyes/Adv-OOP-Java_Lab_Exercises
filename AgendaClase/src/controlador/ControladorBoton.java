package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AgendaInterface;

public class ControladorBoton implements ActionListener{

	private AgendaInterface vista;
	
	public ControladorBoton(AgendaInterface vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		switch(comando){
			case "NUEVO": 
				vista.limpiar();
				break;
			case "AGREGAR":
				vista.getModelo().addElement(vista.getPersona());
				vista.limpiar();
				break;
			case "EDITAR":
				vista.getModelo().set(vista.getIndice(), vista.getPersona());
				vista.limpiar();
				break;
			case "ELIMINAR":
				vista.getModelo().removeElementAt(vista.getIndice());
				vista.limpiar();
				break;
		}
	}
	
	

}
