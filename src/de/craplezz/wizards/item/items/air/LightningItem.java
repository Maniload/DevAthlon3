package de.craplezz.wizards.item.items.air;

import com.google.common.collect.Sets;
import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 * @author Overload
 * @version 1.0
 */
public class LightningItem extends SpecialItem {

    private static final int RADIUS_SQUARED = 36;

    public LightningItem() {
        super(ItemBuilders.normal(Material.BLAZE_ROD).name("§bBlitz §7(20 Sek. Cooldown)").build(), 400);
    }

    @Override
    protected void internalUse(Player player) {
        Block block = player.getTargetBlock(Sets.newHashSet(Material.values()), 100);
        if (block != null) {
            block.getLocation().getWorld().strikeLightningEffect(block.getLocation());

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (!onlinePlayer.equals(player) && onlinePlayer.getLocation().distanceSquared(block.getLocation()) < RADIUS_SQUARED) {
                    onlinePlayer.damage(8, player);
                    onlinePlayer.setFireTicks(onlinePlayer.getFireTicks() + 40);
                }
            }
        }
    }
}
