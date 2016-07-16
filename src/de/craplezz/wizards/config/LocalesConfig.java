package de.craplezz.wizards.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Overload
 * @version 1.0
 */
public class LocalesConfig implements Config {

    private Map<String, String> locales = new HashMap<>();

    public Map<String, String> getLocales() {
        return locales;
    }

}
