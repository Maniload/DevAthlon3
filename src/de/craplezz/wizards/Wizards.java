package de.craplezz.wizards;

import com.google.gson.Gson;
import de.craplezz.wizards.command.KitCommand;
import de.craplezz.wizards.config.ConfigLoader;
import de.craplezz.wizards.config.MainConfig;
import de.craplezz.wizards.game.Game;
import de.craplezz.wizards.listener.block.BlockBreakListener;
import de.craplezz.wizards.listener.block.BlockPlaceListener;
import de.craplezz.wizards.listener.entity.EntityDamageByEntityListener;
import de.craplezz.wizards.listener.entity.EntityExplodeListener;
import de.craplezz.wizards.listener.entity.ProjectileHitListener;
import de.craplezz.wizards.listener.player.*;
import de.craplezz.wizards.manager.ArmorStandManager;
import de.craplezz.wizards.map.WizardsMap;
import de.craplezz.wizards.task.BossBarTask;
import de.craplezz.wizards.user.User;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Overload
 * @version 1.0
 */
public class Wizards extends JavaPlugin {

    private static Wizards instance;

    // Libraries
    private static Gson gson;

    // Configs
    private static MainConfig mainConfig;

    // Manager
    private static ArmorStandManager armorStandManager;

    // Game
    private static Game game;
    private static WizardsMap map;

    // Tasks
    private static BossBarTask bossBarTask;

    @Override
    public void onEnable() {

        instance = this;

        // Libraries
        gson = new Gson();

        try {

            // Configs
            mainConfig = ConfigLoader.load(new File(getDataFolder(), "config.json"), MainConfig.class);

            // Manager
            armorStandManager = new ArmorStandManager();

            // Game
            game = new Game();
            map = new WizardsMap(new File(mainConfig.getMapPath()));
            map.load();

            // Tasks
            bossBarTask = new BossBarTask();
            bossBarTask.runTaskTimer(this, 20L, 1L);

            // Listener
            for (Listener listener : Arrays.asList(
                    new PlayerJoinListener(),
                    new PlayerInteractAtEntityListener(),
                    new PlayerInteractListener(),
                    new PlayerMoveListener(),
                    new BlockBreakListener(),
                    new BlockPlaceListener(),
                    new EntityDamageByEntityListener(),
                    new ProjectileHitListener(),
                    new EntityExplodeListener(),
                    new PlayerDeathListener(),
                    new PlayerFoodLevelChangeListener(),
                    new PlayerItemConsumeListener()
            )) {
                Bukkit.getPluginManager().registerEvents(listener, this);
            }

            // Commands
            getCommand("kit").setExecutor(new KitCommand());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void broadcastPrefixed(String message) {
        for (User user : User.getUsers()) {
            user.sendPrefixedMessage(message);
        }
    }

    public static Wizards getInstance() {
        return instance;
    }

    public static Gson getGson() {
        return gson;
    }

    public static MainConfig getMainConfig() {
        return mainConfig;
    }

    public static ArmorStandManager getArmorStandManager() {
        return armorStandManager;
    }

    public static Game getGame() {
        return game;
    }

    public static WizardsMap getMap() {
        return map;
    }
}
