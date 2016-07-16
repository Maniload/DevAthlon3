package de.craplezz.wizards.config;

import de.craplezz.wizards.Wizards;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;

/**
 * @author Overload
 * @version 1.0
 */
public class MainConfig extends Config {

    private int neededPlayers;
    private Location lobbyLocation = new Location(Bukkit.getWorld("world"), 0, 0, 0);

    public MainConfig() {
        super(new File(Wizards.getInstance().getDataFolder(), "config.json"));
    }

    public int getNeededPlayers() {
        return neededPlayers;
    }

    public Location getLobbyLocation() {
        return lobbyLocation;
    }

}
