package project_XML.writers;

import org.xml.sax.SAXException;
import project_XML.parsers.SAXReader.SAXParserHandler;
import project_XML.weapon.coldWeapon.Knife;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        String filePath = "./project_XML/src/main/resources/new_file.xml";
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler();
            saxParser.parse(new File("./project_XML/src/main/resources/coldWeapon.xml"), handler);
            List<Knife> weapons = handler.getKnifes();
            weapons.forEach(System.out::println);

            XMLWriter.writeToXMLFile(weapons, filePath);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
