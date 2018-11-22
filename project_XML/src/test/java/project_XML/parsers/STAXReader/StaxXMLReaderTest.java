package project_XML.parsers.STAXReader;

import org.junit.Assert;
import org.junit.Test;
import project_XML.weapon.coldWeapon.Knife;

import java.util.List;

public class StaxXMLReaderTest {

    @Test
    public void parseKnives() throws Exception {
        String fileName = "./src/main/resources/coldWeapon.xml";
        StaxXMLReader staxXMLReader = new StaxXMLReader();
        List<Knife> knives = staxXMLReader.parseKnives(fileName);

        Assert.assertEquals(3, knives.size());
    }

}