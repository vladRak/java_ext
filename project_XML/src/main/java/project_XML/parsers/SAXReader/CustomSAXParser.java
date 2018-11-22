package project_XML.parsers.SAXReader;

import org.xml.sax.SAXException;
import project_XML.parsers.ColdWeaponParser;
import project_XML.weapon.coldWeapon.Knife;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomSAXParser implements ColdWeaponParser {

    @Override
    public List<Knife> parseKnives(String filePath) {
        List<Knife> weapons = new ArrayList<>();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler();
            saxParser.parse(new File(filePath), handler);
            weapons = handler.getKnifes();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return weapons;
    }
}
