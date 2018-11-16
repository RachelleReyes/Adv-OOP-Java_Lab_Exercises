package vista;

import javax.swing.DefaultListModel;

import modelo.Persona;

public interface AgendaInterface {
	public void setPersona(Persona p);
	public void limpiar();
	public Persona getPersona();
	public int getIndice();
	public DefaultListModel<Persona> getModelo();
}
