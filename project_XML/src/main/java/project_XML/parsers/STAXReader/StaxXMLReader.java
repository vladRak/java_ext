package project_XML.parsers.STAXReader;

import project_XML.parsers.ColdWeaponParser;
import project_XML.weapon.Handy;
import project_XML.weapon.Material;
import project_XML.weapon.Origin;
import project_XML.weapon.coldWeapon.Knife;
import project_XML.weapon.coldWeapon.Type;
import project_XML.weapon.coldWeapon.Visual;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxXMLReader implements ColdWeaponParser {

    @Override
    public List<Knife> parseKnives(String fileName) {
        List<Knife> knives = new ArrayList<>();
        Knife knife = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("knife")) {
                        knife = new Knife();

                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            knife.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("type")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        knife.setType(Type.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("handy")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        knife.setHandy(Handy.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("origin")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        knife.setOrigin(Origin.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("visual")) {
                        knife.setVisual(getVisual(xmlEventReader));
                    } else if (startElement.getName().getLocalPart().equals("value")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        knife.setValue(Boolean.valueOf(xmlEvent.asCharacters().getData()));
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("knife")) {
                        knives.add(knife);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return knives;
    }

    private Visual getVisual(XMLEventReader xmlEventReader) throws XMLStreamException {
        String length = "";
        String material = "";

        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();

            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                String elementName = startElement.getName().getLocalPart();
                if (elementName.equals("length")) {
                    xmlEvent = xmlEventReader.nextEvent();
                    length = xmlEvent.asCharacters().getData();
                } else if (elementName.equals("material")) {
                    xmlEvent = xmlEventReader.nextEvent();
                    material = xmlEvent.asCharacters().getData();
                }
            } else if (xmlEvent.isEndElement()
                    && xmlEvent.asEndElement().getName().getLocalPart().equals("visual")) {
                return new Visual(Integer.parseInt(length), Material.valueOf(material));
            }
        }
        return new Visual(Integer.parseInt(length), Material.valueOf(material));
    }
}



