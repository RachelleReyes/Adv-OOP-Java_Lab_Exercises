package pruebas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.Persona;

public class TestSerializacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p = new Persona("Pedro",30);
		Persona m = new Persona("Maria",30);
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(p);
		lista.add(m);
		
		try {
			FileOutputStream archivo = new FileOutputStream("archivoPrueba.txt",true); //Escritura archivo
			ObjectOutputStream oos = new ObjectOutputStream(archivo);
			oos.writeObject(lista); //Parametro: lo que se va a escribir
			oos.close();
			archivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream archivoLectura = new FileInputStream("archivoPrueba.txt"); //Lectura archivo
			ObjectInputStream ois = new ObjectInputStream(archivoLectura);
			//Persona res = (Persona)ois.readObject();
			//Object x = ois.readObject();
			ArrayList<Persona>  listaRes =  (ArrayList<Persona>)ois.readObject();
			//ArrayList<Persona>  listaRes2 =  (ArrayList<Persona>)ois.readObject();

			for(Persona item:listaRes) {
				if(item instanceof Persona) 
					System.out.println(item.toString());
			}
			/*if(x instanceof Persona) {
				Persona res = (Persona)x;
				System.out.println(res.toString());
				//System.out.println((Persona)x.toString());
			}*/
			
			ois.close();
			archivoLectura.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//catch (Exception e) 
	
	}

}
