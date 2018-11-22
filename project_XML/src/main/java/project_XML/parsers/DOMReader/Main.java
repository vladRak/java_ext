package project_XML.parsers.DOMReader;

import project_XML.weapon.coldWeapon.Knife;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "./project_XML/src/main/resources/coldWeapon.xml";
        DOMReader domReader = new DOMReader();
        List<Knife> knives = domReader.parseKnives(fileName);
        knives.stream().forEach(knife -> System.out.println(knife));
    }
}
