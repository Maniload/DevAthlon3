package de.craplezz.wizards.config;

import de.craplezz.wizards.util.SimpleLocation;

/**
 * @author Overload
 * @version 1.0
 */
public class MainConfig implements Config {

    private int neededPlayers;
    private SimpleLocation lobbyLocation;

    public int getNeededPlayers() {
        return neededPlayers;
    }

    public SimpleLocation getLobbyLocation() {
        return lobbyLocation;
    }

}
