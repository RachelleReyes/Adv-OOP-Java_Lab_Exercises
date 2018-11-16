package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import modelo.Cuadrado;
import vista.PanelProceso;
import vista.VistaInterface;

public class ControladorBoton implements ActionListener{

	private VistaInterface vista;
	private Random random = new Random();
	
	public ControladorBoton(VistaInterface vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Cuadrado c = new Cuadrado(random.nextInt(300), random.nextInt(300), Color.RED, random.nextInt(50), random.nextInt(5), random.nextInt(5),vista.getDibujo());
		vista.getDibujo().addCuadrado(c);
		Thread t = new Thread(c);
		t.start();
		
	}
	
	
}
