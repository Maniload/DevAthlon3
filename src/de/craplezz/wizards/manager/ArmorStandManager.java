package de.craplezz.wizards.manager;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Overload
 * @version 1.0
 */
public class ArmorStandManager {

    private Map<ArmorStand, Consumer<Player>> ARMOR_STANDS = new HashMap<>();

    public void registerArmorStand(ArmorStand armorStand, Consumer<Player> consumer) {
        ARMOR_STANDS.put(armorStand, consumer);
    }

    public Consumer<Player> getListener(ArmorStand armorStand) {
        return ARMOR_STANDS.get(armorStand);
    }

}
