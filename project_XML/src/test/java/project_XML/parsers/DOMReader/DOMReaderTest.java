package project_XML.parsers.DOMReader;

import org.junit.Assert;
import org.junit.Test;
import project_XML.weapon.coldWeapon.Knife;

import java.util.List;

public class DOMReaderTest {

    @Test
    public void parseKnives() throws Exception {
        String fileName = "./src/main/resources/coldWeapon.xml";
        DOMReader domReader = new DOMReader();
        List<Knife> knives = domReader.parseKnives(fileName);

        Assert.assertEquals(3, knives.size());
    }
}