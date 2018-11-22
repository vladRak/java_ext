package project_XML.validators;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorSAXXSDTest {

    @Test
    public void validateXML() throws Exception {
        String filePath = "./src/main/resources/coldWeapon.xml";
        String schemaPath = "./src/main/resources/coldWeapon.xsd";

        boolean valid = ValidatorSAXXSD.validateXML(filePath, schemaPath);

        Assert.assertEquals(true, valid);
    }

}