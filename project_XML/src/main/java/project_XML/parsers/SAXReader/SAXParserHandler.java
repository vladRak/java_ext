package project_XML.parsers.SAXReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import project_XML.weapon.Handy;
import project_XML.weapon.Material;
import project_XML.weapon.Origin;
import project_XML.weapon.coldWeapon.Knife;
import project_XML.weapon.coldWeapon.Type;
import project_XML.weapon.coldWeapon.Visual;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParserHandler extends DefaultHandler {

    private List<Knife> knives = null;
    private Knife knife = null;

    public List<Knife> getKnifes() {
        return knives;
    }

    private boolean bType, bHandy, bOrigin, bLength, bMaterial, bValue;
    private String knifeLength, material;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("knife")) {
            String id = attributes.getValue("id");

            knife = new Knife();

            knife.setId(Long.valueOf(id));

            if (knives == null)
                knives = new ArrayList<>();

        } else {
            switch (qName.toLowerCase()) {
                case "type":
                    bType = true;
                    break;
                case "handy":
                    bHandy = true;
                    break;
                case "origin":
                    bOrigin = true;
                    break;
                case "length":
                    bLength = true;
                    break;
                case "material":
                    bMaterial = true;
                    break;
                case "value":
                    bValue = true;
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("knife"))
            knives.add(knife);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bType) {
            knife.setType(Type.valueOf(String.valueOf(ch, start, length)));
            bType = false;
        } else if (bHandy) {
            knife.setHandy(Handy.valueOf(String.valueOf(ch, start, length)));
            bHandy = false;
        } else if (bOrigin) {
            knife.setOrigin(Origin.valueOf(String.valueOf(ch, start, length)));
            bOrigin = false;
        } else if (bLength) {
            knifeLength = String.valueOf(ch, start, length);
            bLength = false;
        } else if (bMaterial) {
            material = String.valueOf(ch, start, length);
            knife.setVisual(new Visual(Integer.parseInt(knifeLength), Material.valueOf(material)));
            bMaterial = false;
        }else if (bValue) {
            knife.setValue(Boolean.valueOf(String.valueOf(ch, start, length)));
            bValue = false;
        }
    }
}
//            else if (qName.equalsIgnoreCase("type")) {
//                bType = true;
//            } else if (qName.equalsIgnoreCase("handy")) {
//                bHandy = true;
//            } else if (qName.equalsIgnoreCase("origin")) {
//                bOrigin = true;
//            } else if (qName.equalsIgnoreCase("visual")) {
//                bVisual = true;
//            } else if (qName.equalsIgnoreCase("value")) {
//                bValue = true;
//            }