package de.craplezz.wizards.item.items.fire;

import com.google.common.collect.Sets;
import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * @author Overload
 * @version 1.0
 */
public class MeteorItem extends SpecialItem {

    public MeteorItem() {
        super(ItemBuilders.normal(Material.BLAZE_POWDER).name("§bMeteor §7(20 Sek. Cooldown)").build(), 400);
    }

    @Override
    protected void internalUse(Player player) {
        Block block = player.getTargetBlock(Sets.newHashSet(Material.values()), 100);
        if (block != null) {
            Location location = player.getLocation().clone().add(0, 20, 0);

            Fireball fireball = location.getWorld().spawn(location, Fireball.class);
            fireball.setIsIncendiary(false);
            fireball.setVelocity(new Vector(0, -2, 0));
            fireball.setShooter(player);
        }
    }
}
