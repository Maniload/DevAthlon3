package de.craplezz.wizards.config;

import de.craplezz.wizards.Wizards;

import java.io.File;

/**
 * @author Overload
 * @version 1.0
 */
public class MainConfig extends Config {

    private int neededPlayers;

    public MainConfig() {
        super(new File(Wizards.getInstance().getDataFolder(), "config.json"));
    }

    public int getNeededPlayers() {
        return neededPlayers;
    }

}
