package DAO;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Persona;

public class XMLimport {

	static Document doc;
	
	public static ArrayList<Persona> importarXML(File fichero) {
		doc = null;
		ArrayList<Persona> personas;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc=builder.parse(fichero);
			personas = extraerDatosDelDOM(doc);
			return personas;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Persona> extraerDatosDelDOM(Document doc) {
		Node node;
		ArrayList<Persona> directorio = new ArrayList<Persona>();
		NodeList nodelist = doc.getElementsByTagName("Persona");
		for (int i = 0; i<nodelist.getLength();i++) {
			node = nodelist.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE) {
				//es una persona
				directorio.add(procesarNodoSinCodigo(node));
			}
		}
		return directorio;
	}

	private static Persona procesarNodoSinCodigo(Node node) {
		Element element = (Element)node;
		String nombre = element.getElementsByTagName("Nombre").item(0).getFirstChild().getTextContent();
		int edad = Integer.valueOf(element.getElementsByTagName("Edad").item(0).getFirstChild().getTextContent());
		String dir = element.getElementsByTagName("Direccion").item(0).getFirstChild().getTextContent();
		String codPos = element.getElementsByTagName("CodigoPostal").item(0).getFirstChild().getTextContent();
		String pob = element.getElementsByTagName("Poblacion").item(0).getFirstChild().getTextContent();
		String prov = element.getElementsByTagName("Provincia").item(0).getFirstChild().getTextContent();
		Persona p = new Persona(nombre, edad, dir, codPos, pob, prov);
		return p;
	}
}
