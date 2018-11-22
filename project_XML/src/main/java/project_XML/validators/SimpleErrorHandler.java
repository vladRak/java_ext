package project_XML.validators;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleErrorHandler extends DefaultHandler {

    private Logger logger = LoggerFactory.getLogger(SimpleErrorHandler.class);
    public SimpleErrorHandler(String log) throws IOException {

    }
    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
    }
    public void error(SAXParseException e) {
        logger.error(getLineAddress(e) + " - " + e.getMessage());
    }
    public void fatalError(SAXParseException e) {
        logger.error(getLineAddress(e) + " - " + e.getMessage());
    }
    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
