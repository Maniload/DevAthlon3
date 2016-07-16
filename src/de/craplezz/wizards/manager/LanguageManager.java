package de.craplezz.wizards.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * @author Overload
 * @version 1.0
 */
public class LanguageManager {

    private Map<Locale, Properties> locales = new HashMap<>();

    public LanguageManager(Map<String, String> locales) throws IOException {
        for (Map.Entry<String, String> entry : locales.entrySet()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream(entry.getValue()));
            this.locales.put(Locale.forLanguageTag(entry.getKey()), properties);
        }
    }

    public String getMessage(Locale locale, String languageKey) {
        if (!locales.containsKey(locale) || !locales.get(locale).containsKey(languageKey)) {
            return "N/A";
        }
        return locales.get(locale).getProperty(languageKey);
    }

}
