import hw_3.controllers.impl.VehicleControllerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import hw_3.services.VehicleService;
import hw_3.services.VehicleServiceImpl;
import hw_3.utils.ResourceBundleHelper;
import hw_3.views.View;
import hw_3.views.impl.ViewImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

public class VehicleControllerImplTest {
    private View view;
    private VehicleService vehicleService;
    private VehicleControllerImpl vehicleController;

    @Before
    public void setUp() throws Exception {
        view = new ViewImpl();
        vehicleService = new VehicleServiceImpl();
        vehicleController = new VehicleControllerImpl(view,vehicleService);
    }

    @After
    public void tearDown() throws Exception {
        view = null;
        vehicleService = null;
        vehicleController = null;
    }

    @Test
    public void selectLanguageEn() throws Exception {
        String selectLanguage = "en";
        vehicleController.selectLanguage(new Locale("en"));
        String languageInResource = vehicleController
                .getChoiceListener()
                .getResourceBundle()
                .getLocale()
                .getLanguage();

        assertEquals(selectLanguage,languageInResource);
    }

    @Test
    public void selectLanguageRu() throws Exception {
        String selectLanguage = "ru";
        vehicleController.selectLanguage(new Locale("ru"));
        String languageInResource = vehicleController
                .getChoiceListener()
                .getResourceBundle()
                .getLocale()
                .getLanguage();

        assertEquals(selectLanguage,languageInResource);
    }

    @Test
    public void getSupportedLanguages(){
        List<String> strings = new ArrayList<>();
        strings.add("en");
        strings.add("ru");
        
        List<String> rb = null;
        
        try {
            rb = ResourceBundleHelper.getSupportedLanguages("menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        assertEquals(rb,strings);
    }

    @Test
    public void supportedLanguagesTest() {
        List<String> strings = null;
        List<String> supportedLanguages = null;
        try {

            File inputXmlFile = new File(Thread.currentThread().getContextClassLoader().getResource("").getFile());

            Predicate<String> emailFilter = Pattern
                    .compile("^menu_(.+).properties$")
                    .asPredicate();

            Pattern p = Pattern.compile("^_(.+).properties$");


            strings = Files.walk(Paths.get(inputXmlFile.getParent()))
                    .filter(s -> s.toString().endsWith(".properties"))
                    .map(Path::getFileName)
                    .sorted()
                    .map(Path::toString)
                    .filter(emailFilter)
                    .map(s -> s.split("_",2))
                    .filter(s -> s.length > 1)
                    .map(s -> s[1].split("\\.",2))
                    .map(s -> s[0])
                    .collect(toList());

            supportedLanguages = ResourceBundleHelper.getSupportedLanguages("menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(strings, supportedLanguages);

    }
}