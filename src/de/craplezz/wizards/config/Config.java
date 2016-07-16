package de.craplezz.wizards.config;

import de.craplezz.wizards.Wizards;

import java.io.*;

/**
 * @author Overload
 * @version 1.0
 */
public class Config {

    private File file;

    public Config(File file) {
        this.file = file;
    }

    public void load() throws FileNotFoundException {
        Wizards.getGson().fromJson(new FileReader(file), getClass());
    }

    public void save() throws IOException {
        Wizards.getGson().toJson(this, new FileWriter(file));
    }

}
