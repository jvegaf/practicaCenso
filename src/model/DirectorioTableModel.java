package model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

import UI.PersonaDialog;

public class DirectorioTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> dir = new ArrayList<Persona>();
	private String[] columns = { "Codigo", "Nombre", "Edad", "Direccion", "Codigo Postal", "Poblacion", "Provincia"}; 
	private PersonaDialog pDialog;
	/**
	 * getter 
	 */
	public ArrayList<Persona> getDir() {
		return dir;
	}

	/**
	 * Constructor
	 */
	public DirectorioTableModel() {
	
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dir.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Persona p = dir.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getCodigo();
		case 1:
			return p.getNombre();
		case 2:
			return p.getEdad();
		case 3:
			return p.getDireccion();
		case 4:
			return p.getPoblacion();
		case 5:
			return p.getProvincia();
		case 6:
			return p.getCodigoPostal();
		}
		return "";
	}

	/**
	 * Metodos 
	 */
	public void agregarPersona(Persona p) {
		this.dir.add(p);
	}
	
	/**
	 * agrega una persona en una posicion determinada 
	 */
	public void agregarPersona(int Cod, String nom, int edad, String direc, int cPos, String pobl, String prov) {
		dir.add(new Persona(Cod, nom, edad, direc, cPos, pobl, prov));
	}
	
	/**
	 * Hay que autoasignarle un codigo de persona 
	 */
	public void agregarPersona(String nom, int edad, String direc, int cPos, String pobl, String prov) {
		int codigo = this.obUltimoCod() + 1;
		dir.add(new Persona(codigo, nom, edad, direc, cPos, pobl, prov));
	}
	
	public void quitarPersona(Persona p) {
		for (int i = 0; i < this.dir.size(); i++) {
			if (dir.get(i) == p) {
				dir.remove(i);
			}
		}
	}
	
	/**
	 * obtenemos una referencia de persona dialog 
	 */
	public void getContext(PersonaDialog pd) {
		this.pDialog = pd;
	}
	
	/**
	 * Este metodo tendremos que cambiarlo 
	 * para que nos de el ultimo codigo del fichero.
	 */
	private int obUltimoCod() {
		return dir.size();
	}
	

	public void busca(HashMap<String, String> datos) {
		/**
		 * busqueda por codigo
		 */
		for (Persona p : dir) {
			if (p.getCodigo() == Integer.parseInt(datos.get("codigo"))) {
				pDialog.showPersona(p);
			}else{
				/**
				 * TODO: sacar un JDialog para advertir de 
				 * que no existe esa persona
				 */
			}
		}
	}
	
}
