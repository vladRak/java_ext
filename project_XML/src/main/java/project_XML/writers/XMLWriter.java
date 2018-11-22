package project_XML.writers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import project_XML.weapon.coldWeapon.Knife;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLWriter {

    public static void writeToXMLFile(List<Knife> knives, String filePath) {

        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;

        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.newDocument();

            Element root = doc.createElement("coldWeapons");
            doc.appendChild(root);

            for (Knife knife : knives) {
                Element knifeXML = doc.createElement(Knife.getXmlNodeName());
                knifeXML.setAttribute("id", String.valueOf(knife.getId()));
                root.appendChild(knifeXML);

                Element type = doc.createElement("type");
                type.setTextContent(String.valueOf(knife.getType()));
                knifeXML.appendChild(type);

                Element handy = doc.createElement("handy");
                handy.setTextContent(String.valueOf(knife.getHandy()));
                knifeXML.appendChild(handy);

                Element origin = doc.createElement("origin");
                origin.setTextContent(String.valueOf(knife.getOrigin()));
                knifeXML.appendChild(origin);

                Element visual = doc.createElement("visual");

                Element visualLength = doc.createElement("length");
                visualLength.setTextContent(String.valueOf(knife.getVisual().getLength()));
                visual.appendChild(visualLength);

                Element visualMaterial = doc.createElement("material");
                visualMaterial.setTextContent(String.valueOf(knife.getVisual().getMaterial()));
                visual.appendChild(visualMaterial);

                knifeXML.appendChild(visual);

                Element value = doc.createElement("value");
                value.setTextContent(String.valueOf(knife.isValue()));
                knifeXML.appendChild(value);
            }

            writeToFile(doc, filePath);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(Document doc, String filePath) throws TransformerException {
        Source domSource = new DOMSource(doc);
        Result fileResult = new StreamResult(new File(filePath));
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(domSource, fileResult);
    }
}
