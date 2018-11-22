package project_XML.parsers.STAXReader;

import project_XML.weapon.coldWeapon.Knife;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "./project_XML/src/main/resources/coldWeapon.xml";
        StaxXMLReader staxXMLReader = new StaxXMLReader();
        List<Knife> knives = staxXMLReader.parseKnives(fileName);
        for (Knife knife : knives) {
            System.out.println(knife.toString());
        }
    }
}
