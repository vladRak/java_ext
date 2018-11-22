package project_XML.writers;

import org.junit.Assert;
import org.junit.Test;
import project_XML.parsers.SAXReader.CustomSAXParser;
import project_XML.weapon.coldWeapon.Knife;

import java.util.List;

public class XMLWriterTest {

    @Test
    public void writeToXMLFile() throws Exception {

        String filePath = "./src/main/resources/coldWeapon.xml";
        String newFilePath = "./src/main/resources/new_file.xml";

        CustomSAXParser customSAXParser = new CustomSAXParser();
        List<Knife> weapons = customSAXParser.parseKnives(filePath);

        XMLWriter.writeToXMLFile(weapons, newFilePath);

        List<Knife> newWeapons = customSAXParser.parseKnives(newFilePath);

        Assert.assertEquals(weapons,newWeapons);
    }
}