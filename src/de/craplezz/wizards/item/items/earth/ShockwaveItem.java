package de.craplezz.wizards.item.items.earth;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author Overload
 * @version 1.0
 */
public class ShockwaveItem extends SpecialItem {

    public ShockwaveItem() {
        super(ItemBuilders.normal(Material.ANVIL).name("§bDruckwelle §7(20 Sek. Cooldown)").build(), 400);
    }

    @Override
    protected void internalUse(Player player) {
        new BukkitRunnable() {

            int radius = 1;

            @Override
            public void run() {
                if (radius++ < 7) {
                    for (double angle = 0; angle < Math.PI * 2; angle += Math.PI / (radius * 2)) {
                        Location location = player.getLocation().clone().add(Math.sin(angle) * radius, 0, Math.cos(angle) * radius);
                        player.getWorld().spigot().playEffect(location, Effect.TILE_DUST);
                        player.playSound(location, Sound.BLOCK_GRAVEL_BREAK, 1f, 1f);
                    }

                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        if (!onlinePlayer.equals(player) && onlinePlayer.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR &&
                                onlinePlayer.getLocation().distanceSquared(player.getLocation()) <= radius * radius) {
                            onlinePlayer.setVelocity(onlinePlayer.getVelocity().setY(3));
                        }
                    }
                }
                else {
                    cancel();
                }
            }

        }.runTaskTimer(Wizards.getInstance(), 0L, 1L);
        for (int radius = 1; radius < 7; radius++) {

        }
    }
}
