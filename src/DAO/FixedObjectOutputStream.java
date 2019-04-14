package DAO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FixedObjectOutputStream extends ObjectOutputStream{

	protected FixedObjectOutputStream() throws IOException, SecurityException {
		super();
	}

	public FixedObjectOutputStream(FileOutputStream fileOutputStream) throws IOException{
		super(fileOutputStream);
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		/*
		 * de esta manera chusquera evitamos que nos cree
		 * una cabecera por cada sesion de escritura del 
		 * fichero
		 */
	}
	
	
}
