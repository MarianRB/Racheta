package data;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class WritingXML {

	public static void write(CLocalitate loc) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		Document document = null;
		try {
			document = builder.parse("LocalitatiO.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		document.normalize();
		
		Element localitati = (Element) document.getElementsByTagName("localitati").item(0);
		Element new_loc = document.createElement("localitate");
		new_loc.setAttribute("name", loc.get_name());
		
		Element latN = document.createElement("latN");
		latN.setTextContent(Double.toString(loc.get_coord().getLatN()));
		
		Element latS = document.createElement("latS");
		latS.setTextContent(Double.toString(loc.get_coord().getLatS()));
		
		Element longiE = document.createElement("longiE");
		longiE.setTextContent(Double.toString(loc.get_coord().getLongiE()));
		
		Element longiV = document.createElement("longiV");
		longiV.setTextContent(Double.toString(loc.get_coord().getLongiV()));
		
		new_loc.appendChild(latN);
		new_loc.appendChild(latS);
		new_loc.appendChild(longiE);
		new_loc.appendChild(longiV);
		
		localitati.appendChild(new_loc);
		
		DOMSource source = new DOMSource(document);
		TransformerFactory transformer_factory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformer_factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		
		StreamResult result = new StreamResult("LocalitatiO.xml");
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}	
}