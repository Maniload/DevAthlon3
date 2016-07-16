package de.craplezz.wizards.map;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.config.MapConfig;
import de.craplezz.wizards.kit.KitType;
import de.craplezz.wizards.user.User;
import de.craplezz.wizards.util.SimpleLocation;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

/**
 * @author Overload
 * @version 1.0
 */
public class LobbyMap {

    private MapConfig mapConfig;

    public LobbyMap(MapConfig mapConfig) {
        this.mapConfig = mapConfig;
    }

    public void prepare() {
        World world = Bukkit.getWorld("world");

        for (Entity entity : world.getEntities()) {
            entity.remove();
        }

        int index = 0;
        for (SimpleLocation simpleLocation : mapConfig.getArmorStandLocations()) {
            KitType kitType = KitType.values()[index++];

            ArmorStand armorStand = world.spawn(simpleLocation.toBukkitLocation(world), ArmorStand.class);
            armorStand.setArms(true);
            armorStand.setBasePlate(false);
            armorStand.setCustomNameVisible(true);
            armorStand.setCustomName(kitType.getKit().getName());
            armorStand.setGravity(false);

            kitType.getKit().apply(armorStand);

            Wizards.getArmorStandManager().registerArmorStand(armorStand, new Consumer<Player>() {

                @Override
                public void accept(Player player) {
                    User user = User.getUser(player);
                    user.changeKit(kitType);

                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                }

            });
        }
    }

}
