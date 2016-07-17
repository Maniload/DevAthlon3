package de.craplezz.wizards.item.items;

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
public class WandItem extends SpecialItem {

    private static final int RADIUS_SQUARED = 4;

    public WandItem() {
        super(ItemBuilders.normal(Material.STICK).name("§bZauberstab").build(), 0);
    }

    @Override
    protected void internalUse(Player player) {
        for (int lenght = 1; lenght < 6; lenght++) {
            Location location = player.getEyeLocation().clone().add(player.getLocation().getDirection().multiply(lenght));
            location.getWorld().spigot().playEffect(location, Effect.CLOUD, 0, 0, 0, 0, 0, 0, 1, 64);

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (!onlinePlayer.equals(player) && onlinePlayer.getLocation().distanceSquared(location) <= RADIUS_SQUARED) {
                    onlinePlayer.damage(2, player);
                }
            }
        }
    }
}
