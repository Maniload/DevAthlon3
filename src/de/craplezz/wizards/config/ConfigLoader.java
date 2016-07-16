package de.craplezz.wizards.config;

import de.craplezz.wizards.Wizards;

import java.io.*;

/**
 * @author Overload
 * @version 1.0
 */
public class ConfigLoader {

    public static <T extends Config> T load(File file, Class<T> clazz) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        return Wizards.getGson().fromJson(new FileReader(file), clazz);
    }

}
