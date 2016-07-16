package de.craplezz.wizards.map;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.config.ConfigLoader;
import de.craplezz.wizards.config.MapConfig;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Overload
 * @version 1.0
 */
public class WizardsMap {

    private static final String WORLD_NAME = "map";

    private File worldDir;
    private World world;

    private MapConfig mapConfig;

    public WizardsMap(File worldDir) {
        this.worldDir = worldDir;
    }

    public void load() throws IOException {
        WorldCreator worldCreator = new WorldCreator(WORLD_NAME);
        world = worldCreator.createWorld();

        mapConfig = ConfigLoader.load(new File(worldDir, "config.json"), MapConfig.class);

        prepare();
    }

    public void prepare() {

    }

    public void teleportPlayers() {
        List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());

        new BukkitRunnable() {

            int index = 0;

            @Override
            public void run() {
                if (players.size() > index && mapConfig.getSpawnLocations().size() > index) {
                    players.get(index).teleport(mapConfig.getSpawnLocations().get(index++).toBukkitLocation(world));
                }
                else {
                    cancel();
                }
            }

        }.runTaskTimer(Wizards.getInstance(), 0L, 1L);
    }

    public World getWorld() {
        return world;
    }

    public MapConfig getMapConfig() {
        return mapConfig;
    }

}
