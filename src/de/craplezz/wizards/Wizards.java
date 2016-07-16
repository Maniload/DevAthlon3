package de.craplezz.wizards;

import com.google.gson.Gson;
import de.craplezz.wizards.config.MainConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;

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

    @Override
    public void onEnable() {

        instance = this;

        // Libraries
        gson = new Gson();

        // Configs
        mainConfig = new MainConfig();
        try {
            mainConfig.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

}
