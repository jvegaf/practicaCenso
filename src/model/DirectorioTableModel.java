package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import DAO.DAOEntrada;
import DAO.DAOSalida;
import DAO.XMLimport;
import UI.PersonaDialog;
import Utils.RecentFile;
import Utils.RecentsFileUtil;

public class DirectorioTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> dir = new ArrayList<Persona>();
	private String[] columns = { "Codigo", "Nombre", "Edad", "Direccion", "Codigo Postal", "Poblacion", "Provincia"}; 
	private PersonaDialog pDialog;
	private Persona pSelected;
	
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
			return p.getCodigoPostal();
		case 5:
			return p.getPoblacion();
		case 6:
			return p.getProvincia();
		}
		return "";
	}

	/**
	 * Metodos 
	 */
	public void agregarPersona(Persona p) {
		int codigo  = this.obUltimoCod()+1;
		p.setCodigo(codigo);
		this.dir.add(p);
		this.fireTableDataChanged();
	}
	
	/**
	 * agregar persona en una posicion determinada
	 */
	
	public void agregarPersona(Persona p, int codigo) {
		p.setCodigo(codigo);
		this.dir.add(p);
		this.fireTableDataChanged();
	}
	
	/**
	 * agrega una persona en una posicion determinada 
	 */
	public void agregarPersona(int cod,String nom, int edad, String direc, String cPos, String pobl, String prov) {
		dir.add(new Persona(cod, nom, edad, direc, cPos, pobl, prov));
		this.fireTableDataChanged();
	}
	
	/**
	 * Hay que autoasignarle un codigo de persona 
	 */
	public void agregarPersona(String nom, int edad, String direc, String cPos, String pobl, String prov) {
		int codigo = this.obUltimoCod() + 1;
		dir.add(new Persona(codigo, nom, edad, direc, cPos, pobl, prov));
		this.fireTableDataChanged();
	}
	
	private void agregarPersonas(ArrayList<Persona> personas) {
		for (Persona p : personas) {
			this.agregarPersona(p);
		}
		this.fireTableDataChanged();
	}
	
	public void quitarPersona(Persona p) {
		for (int i = 0; i < this.dir.size(); i++) {
			if (dir.get(i) == p) {
				dir.remove(i);
			}
		}
		this.fireTableDataChanged();
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

	public void getDataDeFichero(File fichero) throws IOException{
		this.dir = DAOEntrada.getDatosDeFichero(fichero);
		if(this.dir != null && this.dir.size() > 0) {
			
			this.agregarFicheroReciente(fichero);
		}
		this.fireTableDataChanged();
	}

	public void importarXML(File XMLFile) {
		ArrayList<Persona> personas = XMLimport.importarXML(XMLFile);
		this.agregarPersonas(personas);
	}

	public void guardaEnFichero(File fichero) throws IOException {
		// TODO Auto-generated method stub
		DAOSalida.guardaEnFichero(dir, fichero);
	}
	
	private void agregarFicheroReciente(File fichero) {
		RecentFile file = new RecentFile(fichero.getName(), fichero.getAbsolutePath());
		try {
			RecentsFileUtil.agregarFicheroReciente(file);
		} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Devuelve una persona determinada del directorio
	 */
	
	public Persona getPersona(int i) {
		pSelected = this.dir.get(i);
		return pSelected;
	}

	public void modificaPersona(Persona pNueva) {
		for(int i=0;i<this.dir.size();i++) {
			if(pSelected == this.dir.get(i)) {
				this.dir.set(i, pNueva);
			}
		}
		this.fireTableDataChanged();
	}
	
}
