package de.craplezz.wizards.item.items.water;

import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * @author Overload
 * @version 1.0
 */
public class WaterGunItem extends SpecialItem {

    private static final int RADIUS_SQUARED = 2;

    public WaterGunItem() {
        super(ItemBuilders.normal(Material.WATER_BUCKET).name("§bWasser Strahl §7(10 Sek. Cooldown)").build(), 200);
    }

    @Override
    protected void internalUse(Player player) {
        for (int lenght = 1; lenght < 6; lenght++) {
            Location location = player.getLocation().clone().add(player.getLocation().getDirection().multiply(lenght));
            location.getWorld().spigot().playEffect(location, Effect.SPLASH, 0, 0, 1, 1, 1, 1, 10, 64);

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (!onlinePlayer.equals(player) && onlinePlayer.getLocation().distanceSquared(player.getLocation()) <= 2) {
                    onlinePlayer.setVelocity(player.getLocation().getDirection().multiply(3));
                }
            }
        }
    }
}
