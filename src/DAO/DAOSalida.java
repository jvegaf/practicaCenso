package DAO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Persona;

public class DAOSalida {

	public static void guardaEnFichero(ArrayList<Persona> dir, File fichero) throws IOException {
		/**
		 * FixedOutputStream es una herencia propia 
		 * para solucionar un peque�o problemilla
		 */
		//FixedObjectOutputStream oos = new FixedObjectOutputStream(new FileOutputStream(fichero));
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
		for(Persona p : dir) {
			oos.writeObject(p);
		}
		oos.close();
	}
	
	/* public static void guardaEnFicheroConPosicion() */

}
