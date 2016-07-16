package de.craplezz.wizards;

import com.google.gson.Gson;
import de.craplezz.wizards.config.ConfigLoader;
import de.craplezz.wizards.config.LocalesConfig;
import de.craplezz.wizards.config.MainConfig;
import de.craplezz.wizards.game.Game;
import de.craplezz.wizards.listener.player.PlayerJoinListener;
import de.craplezz.wizards.manager.LanguageManager;
import de.craplezz.wizards.map.WizardsMap;
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
    private static LocalesConfig localesConfig;

    // Manager
    private static LanguageManager languageManager;

    // Game
    private static Game game;
    private static WizardsMap map;

    @Override
    public void onEnable() {

        instance = this;

        // Libraries
        gson = new Gson();

        try {

            // Configs
            mainConfig = ConfigLoader.load(new File(getDataFolder(), "config.json"), MainConfig.class);
            localesConfig = ConfigLoader.load(new File(getDataFolder(), "locales.json"), LocalesConfig.class);

            // Manager
            languageManager = new LanguageManager(localesConfig.getLocales());

            // Game
            game = new Game();
            map = new WizardsMap();
            map.load();

            // Listener
            for (Listener listener : Arrays.asList(
                    new PlayerJoinListener()
            )) {
                Bukkit.getPluginManager().registerEvents(listener, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void broadcast(String languageKey, Object... args) {
        for (User user : User.getUsers()) {
            user.sendMessage(languageKey, args);
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

    public static LocalesConfig getLocalesConfig() {
        return localesConfig;
    }

    public static LanguageManager getLanguageManager() {
        return languageManager;
    }

    public static Game getGame() {
        return game;
    }

    public static WizardsMap getMap() {
        return map;
    }
}
