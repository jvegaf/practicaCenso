package DAO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DAOGeneral {

	/**
	 * 	 CADA REGISTRO
	 *   int codigo 		4 bytes
	 *   String nombre		30bytes 1byte char * 30chars
	 *   int edad			4 bytes
	 *   String direccion	30 bytes 1byte char * 30 chars
	 *   int codigo postal	4 bytes
	 *   String poblacion	20 bytes 1byte char * 20 chars
	 *	 String provincia	20 bytes 1byte char * 20 chars
	 *
	 *   TOTAL			   112 bytes redondeamos a 120bytes	 
	 */
	
	protected static int numeroRegs;
	protected static RandomAccessFile flujo;
	static final int regSize = 120;
	
	public static void getNumRegs(File fichero) throws IOException {
		flujo = new RandomAccessFile(fichero, "r");
		numeroRegs = (int)Math.ceil((double)flujo.length()/(double) regSize);
		flujo.close();
	}
	
	
}
