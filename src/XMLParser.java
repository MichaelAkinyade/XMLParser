import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      File file = new File("THIRD_PARTIES_ACTIVE_ADDRESS-24302-2019-03-17.xml");
	      Document document = builder.parse(file);
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("ThirdParty");
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            //Create new Employee Object
	            if(eElement.getElementsByTagName("addressee").getLength()>1) {
	            	// display all elements within the node
	            	//System.out.println(eElement.getTextContent().toString());
	            	System.out.println("got here");
	            	System.out.println( eElement.getElementsByTagName("externalID").item(0).getTextContent());
	            }
	            //display a specific element's context
	           // eElement.getElementsByTagName("addressee").item(0).getTextContent();

	         }
	      }
	   }			

}
