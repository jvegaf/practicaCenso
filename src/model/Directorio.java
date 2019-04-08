package model;

import java.util.ArrayList;

public class Directorio {

	private ArrayList<Persona> directorio;
	
	
	/**
	 * Getters & Setters 
	 */
	public ArrayList<Persona> getDirectorio() {
		return directorio;
	}

	public void setDirectorio(ArrayList<Persona> directorio) {
		this.directorio = directorio;
	}
	
	/**
	 * Constructor
	 */

	public Directorio() {
		this.directorio = new ArrayList<Persona>();
	}
	
	public Directorio(ArrayList<Persona> dic) {
		this.directorio = dic;
	}
	
	
	
	
	
}
