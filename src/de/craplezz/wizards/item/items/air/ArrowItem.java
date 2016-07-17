package de.craplezz.wizards.item.items.air;

import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TippedArrow;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.bukkit.util.Vector;

/**
 * @author Overload
 * @version 1.0
 */
public class ArrowItem extends SpecialItem {

    public ArrowItem() {
        super(ItemBuilders.normal(Material.ARROW).name("§bPfeile §7(10 Sek. Cooldown)").build(), 200);
    }

    @Override
    protected void internalUse(Player player) {
        for (int x = -1; x < 1; x++) {
            for (int z = -1; z < 1; z++) {
                if (x == 0 || z == 0) {
                    continue;
                }
                Location location = player.getLocation().clone().add(0, 2, 0);

                TippedArrow arrow = location.getWorld().spawn(location, TippedArrow.class);
                arrow.setShooter(player);
                arrow.setBasePotionData(new PotionData(PotionType.SLOWNESS));
                arrow.setVelocity(new Vector(x, 0, z).multiply(2.5));
            }
        }
    }
}
