package project_XML.parsers.SAXReader;

import org.junit.Assert;
import org.junit.Test;
import project_XML.weapon.coldWeapon.Knife;

import java.util.List;

public class CustomSAXParserTest {

    @Test
    public void parseKnives() throws Exception {
        CustomSAXParser customSAXParser = new CustomSAXParser();
        String fileName = "./src/main/resources/coldWeapon.xml";
        List<Knife> weapons = customSAXParser.parseKnives(fileName);

        Assert.assertEquals(3, weapons.size());
    }

}