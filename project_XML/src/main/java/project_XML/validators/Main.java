package project_XML.validators;

public class Main {
    public static void main(String[] args) {
        String filePath = "./project_XML/src/main/resources/coldWeapon.xml";
        String schemaPath = "./project_XML/src/main/resources/coldWeapon.xsd";

        boolean valid = ValidatorSAXXSD.validateXML(filePath,schemaPath);
        System.out.println(filePath + " valid: " + valid);
    }
}
