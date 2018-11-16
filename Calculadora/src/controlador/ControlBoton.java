package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistas.Interfaz;

public class ControlBoton implements ActionListener {

	private Interfaz gui;
	public ControlBoton(Interfaz gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand(); //QUE BOTON EJECUTA
		double res = 0;
		
		switch(comando) {
		case "Sumar":
				res = gui.getOperador1() + gui.getOperador2();
				break;
		case "Resta":
			res = gui.getOperador1() - gui.getOperador2();
			break;
		case "Multiplicar":
			res = gui.getOperador1()*gui.getOperador2();
			break;

		case "Dividir":
				res = gui.getOperador1()/gui.getOperador2();
				break;
		}
		
		gui.setResultado(res);
	} 

}
