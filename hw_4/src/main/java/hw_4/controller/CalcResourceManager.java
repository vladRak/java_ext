package hw_4.controller;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public enum CalcResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "calc";

    CalcResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }

    public Set<String> keySet() {
        return resourceBundle.keySet();
    }
}
