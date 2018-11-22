package project_XML.parsers.DOMReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import project_XML.parsers.ColdWeaponParser;
import project_XML.weapon.Handy;
import project_XML.weapon.Material;
import project_XML.weapon.Origin;
import project_XML.weapon.coldWeapon.Knife;
import project_XML.weapon.coldWeapon.Type;
import project_XML.weapon.coldWeapon.Visual;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMReader implements ColdWeaponParser {

    @Override
    public List<Knife> parseKnives(String filePath) {
        List<Knife> knives = new ArrayList<>();

        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName(Knife.getXmlNodeName());

            for (int i = 0; i < nodeList.getLength(); i++) {
                knives.add(getKnife(nodeList.item(i)));
            }

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }

        return knives;
    }

    private static Knife getKnife(Node node) {

        Knife knife = new Knife();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            knife.setId(Long.valueOf(getAttributeValue("id", element)));
            knife.setType(Type.valueOf(getTagValue("type", element)));
            knife.setHandy(Handy.valueOf(getTagValue("handy", element)));
            knife.setOrigin(Origin.valueOf(getTagValue("origin", element)));
            try {
                String length = getChildTagValue("visual", "length", element);
                String material = getChildTagValue("visual", "material", element);
                knife.setVisual(new Visual(Integer.parseInt(length), Material.valueOf(material)));
            } catch (Exception ex) {
                knife.setVisual(new Visual(0, Material.Steel));
            }
            knife.setValue(Boolean.valueOf(getTagValue("value", element)));
        }

        return knife;
    }

    private static String getAttributeValue(String tag, Element element) {
        String attribute = element.getAttribute(tag);
        return attribute;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private static String getChildTagValue(String parentTag, String childTag, Element element) {
        String tagValue = getTagValue(childTag,
                (Element) (element.getElementsByTagName(parentTag).item(0)));
        return tagValue;
    }
}
