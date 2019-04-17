package Utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class RecentsFileUtil {
	
		
	public static File getRecentsFilesSupportFile() {
		
		File recentsSupportFile;
		
		File configDir = new File("config");
		if(!configDir.exists()) {
			configDir.mkdir();
		}
		recentsSupportFile = new File(configDir, "recents.xml");
		if(!recentsSupportFile.exists()) {
			try {
				recentsSupportFile.createNewFile();
			} catch (IOException e) {
				System.out.println("No se ha podido crear el fichero de configuracion");
				e.printStackTrace();
			}
		}
		return recentsSupportFile;
	}

	public static void agregarFicheroReciente(RecentFile file) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		File rsf = getRecentsFilesSupportFile();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation impl = builder.getDOMImplementation();
		/* Puede que pete por el primer parametro.....*/
		Document doc = impl.createDocument(rsf.getAbsolutePath(), rsf.getName(), null);
		doc.setXmlVersion("1.0");
		/**
		 * <RecentFiles>
		 *     <File>
		 *         <FileName>
		 *             "%FILENAME%"
		 *         </FileName>
		 *         <FilePath>
		 *             "%PATH_TO_FILE%"
		 *         </FilePath>
		 * 	   </File>
		 * </RecenFiles> 
		 */
		Element raiz = doc.getDocumentElement();
		Element fileElement = doc.createElement("File");
		Element fileName = doc.createElement("FileName");
		Text fileNameValue = doc.createTextNode(file.getNombreFichero());
		fileName.appendChild(fileNameValue);
		Element filePath = doc.createElement("FilePath");
		Text filePathValue = doc.createTextNode(file.getRutaCompleta());
		filePath.appendChild(filePathValue);
		fileElement.appendChild(fileName);
		fileElement.appendChild(filePath);
		raiz.appendChild(fileElement);
		
		Source source = new DOMSource(doc);
		Result result = new StreamResult(rsf);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
	}
	
}
