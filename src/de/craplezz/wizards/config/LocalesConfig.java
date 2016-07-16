package de.craplezz.wizards.config;

import de.craplezz.wizards.Wizards;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Overload
 * @version 1.0
 */
public class LocalesConfig extends Config {

    private Map<String, String> locales = new HashMap<>();

    public LocalesConfig() {
        super(new File(Wizards.getInstance().getDataFolder(), "locales.json"));
    }

    public Map<String, String> getLocales() {
        return locales;
    }

}
