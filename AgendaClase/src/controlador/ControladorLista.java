package controlador;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Persona;
import vista.AgendaInterface;

public class ControladorLista implements ListSelectionListener {

	private AgendaInterface vista;
	public ControladorLista(AgendaInterface vista) {
		this.vista=vista;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		JList lista=(JList) e.getSource();
		if(lista.getSelectedIndex()!= -1)
			vista.setPersona((Persona)lista.getSelectedValue());
		//System.out.println(lista.getSelectedValue().toString());
	}

}
