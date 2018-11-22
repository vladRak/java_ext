package project_XML.validators;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAXXSD {

    public static boolean validateXML(String filePats, String schemaPath) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaPath);
        boolean valid = false;
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filePats);
            validator.validate(source);
            valid = true;
            System.out.println(filePats + " is valid.");
        } catch (SAXException e) {
            System.err.print("validation " + filePats + " is not valid because "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(filePats + " is not valid because "
                    + e.getMessage());
        }
        return valid;
    }
}