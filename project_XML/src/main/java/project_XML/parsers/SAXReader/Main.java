package project_XML.parsers.SAXReader;

import project_XML.weapon.coldWeapon.Knife;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomSAXParser customSAXParser = new CustomSAXParser();
        String fileName = "./project_XML/src/main/resources/coldWeapon.xml";
        List<Knife> weapons = customSAXParser.parseKnives(fileName);
        weapons.forEach(System.out::println);
    }
}
