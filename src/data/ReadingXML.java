package data;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import data.CCoordonate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Vector;



public class ReadingXML {

	public static CLocalitate[] read() {

		
		Vector<CLocalitate> localitatiV = new Vector<CLocalitate>(0);
        //Get the Document Builder

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Get Document
            Document document = builder.parse(new File("LocalitatiO.xml"));

            // Normalize the xml structure
           document.getDocumentElement().normalize();

            NodeList ListaLocalitati = document.getElementsByTagName("localitate");
            for(int i = 0; i <ListaLocalitati.getLength(); i++) {
                Node localitate = ListaLocalitati.item(i);
                if(localitate.getNodeType() == Node.ELEMENT_NODE) {

                    Element localitateElement = (Element) localitate;
                    CLocalitate loc = new CLocalitate();
                    CCoordonate coo = new CCoordonate();
                    loc.set_name(localitateElement.getAttribute("name"));
                    coo.setLatN(Double.parseDouble(localitateElement.getElementsByTagName("latN").item(0).getTextContent()));
                    coo.setLatS(Double.parseDouble(localitateElement.getElementsByTagName("latS").item(0).getTextContent()));
                    coo.setLongiE(Double.parseDouble(localitateElement.getElementsByTagName("longiE").item(0).getTextContent()));
                    coo.setLongiV(Double.parseDouble(localitateElement.getElementsByTagName("longiV").item(0).getTextContent()));
                    loc.set_coord(coo);
                    localitatiV.addElement(loc);
                }
            }
            


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        CLocalitate[] loc_array = new CLocalitate[localitatiV.size()];
        for(int i =0;i<localitatiV.size();i++)
        {
        	loc_array[i] = localitatiV.get(i);
        }
        return loc_array;
    }
}



