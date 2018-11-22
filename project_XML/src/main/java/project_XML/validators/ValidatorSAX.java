package project_XML.validators;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {

    public static boolean validateXML(String filePats, String schemaPath) {
        boolean valid = false;
        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            schema = factory.newSchema(new File(schemaPath));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(filePats, new SimpleErrorHandler("sax_error.log"));
            System.out.println(filePats + " is valid");
        } catch (ParserConfigurationException e) {
            System.err.println(filePats + " config error: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println(filePats + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
        return valid;
    }
}
