package model;

public class Persona {
	
	private int codigo;
	private String nombre;
	private int edad;
	private String direccion;
	private int codigoPostal;
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
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
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
	
	public Persona(int codigo, String nombre, int edad, String direccion, int codigoPostal, String poblacion,
			String provincia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	
	
}
