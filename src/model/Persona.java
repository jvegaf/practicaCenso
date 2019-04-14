package model;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private static final long serialVersionUID = -466263323017385279L;
	private int codigo;
	private String nombre;
	private int edad;
	private String direccion;
	private String codigoPostal;
	private String poblacion;
	private String provincia;
	
	/**
	 * Getters & Setters
	 */
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	/**
	 * Constructores
	 */
	
	/**
	 *  Constructor con codigo de persona determinado manualmente
	 */
	
	public Persona(int codigo, String nombre, int edad, String direccion, String codigoPostal, String poblacion,
			String provincia) {
		super();
		
		/*TODO: Comprobacion de que el codigo no existe todavia
		 * en caso de que exista se sobreecribe la informacion*/ 
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	
	/**
	 *  El codigo de la persona se crea automaticamente
	 */
	public Persona(String nombre, int edad, String direccion, String codigoPostal, String poblacion, String provincia) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	
	
	
}
