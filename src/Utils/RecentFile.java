package Utils;

/**
 *  Este es un modelo del objeto fichero
 */
public class RecentFile {

	private String nombreFichero;
	private String rutaCompleta;
	
	/**
	 * Getters & Setters
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}
	public String getRutaCompleta() {
		return rutaCompleta;
	}
	public void setRutaCompleta(String rutaCompleta) {
		this.rutaCompleta = rutaCompleta;
	}
	
	/**
	 * Constructor
	 */

	public RecentFile(String nombreFichero, String rutaCompleta) {
		super();
		this.nombreFichero = nombreFichero;
		this.rutaCompleta = rutaCompleta;
	}	
}
