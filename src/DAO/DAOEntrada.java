package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.Persona;

public class DAOEntrada extends DAOGeneral{
	
	public void leerDeFichero(int numeroRegistro){
		
	}

	public static ArrayList<Persona> getDatosDeFichero(File fichero) throws FileNotFoundException, IOException{
		ArrayList<Persona> directorio = new ArrayList<Persona>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
		Persona p = null;
		try {
			p = (Persona)ois.readObject();
			directorio.add(p);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			ois.close();
		}
		while(p!=null) {
			try {
				p = (Persona)ois.readObject();
				directorio.add(p);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				ois.close();
			}
		}
		ois.close();
		return directorio;
		
	}
	
}
