package de.craplezz.wizards.util;

import org.bukkit.Location;
import org.bukkit.World;

/**
 * @author Overload
 * @version 1.0
 */
public class SimpleLocation {

    private double x, y, z;
    private float yaw, pitch;

    public Location toBukkitLocation(World world) {
        return new Location(world, x, y, z, yaw, pitch);
    }

}
