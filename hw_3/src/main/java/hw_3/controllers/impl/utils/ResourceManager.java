package hw_3.controllers.impl.utils;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "menu";

    ResourceManager() {
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
