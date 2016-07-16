package de.craplezz.wizards.item.items;

import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * @author Overload
 * @version 1.0
 */
public class FeatherItem extends SpecialItem {

    public FeatherItem() {
        super(ItemBuilders.normal(Material.FEATHER).name("§bSchwung §7(5 Sek. Cooldown)").build(), 100);
    }

    @Override
    protected void internalUse(Player player) {
        player.setVelocity(player.getLocation().getDirection().normalize().multiply(3.0).setY(0.2));
        player.playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1f, 1f);
    }
}
