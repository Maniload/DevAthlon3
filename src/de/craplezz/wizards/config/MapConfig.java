package de.craplezz.wizards.config;

import de.craplezz.wizards.util.SimpleLocation;

import java.util.List;

/**
 * @author Overload
 * @version 1.0
 */
public class MapConfig implements Config {

    private List<SimpleLocation> spawnLocations;
    private List<SimpleLocation> armorStandLocations;

    public List<SimpleLocation> getSpawnLocations() {
        return spawnLocations;
    }

    public List<SimpleLocation> getArmorStandLocations() {
        return armorStandLocations;
    }

}
