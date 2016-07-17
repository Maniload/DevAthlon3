package de.craplezz.wizards.item.items.water;

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
public class IceSnakeItem extends SpecialItem {

    private static final int RADIUS_SQUARED = 2;

    public IceSnakeItem() {
        super(ItemBuilders.normal(Material.PRISMARINE_SHARD).name("§bEis Schlange §7(20 Sek. Cooldown)").build(), 400);
    }

    @Override
    protected void internalUse(Player player) {
        new BukkitRunnable() {

            int length = 1;
            Location location = player.getLocation().clone();

            @Override
            public void run() {
                if (length++ < 10) {
                    Location subLocation = location.add(player.getLocation().getDirection()).clone();

                    subLocation.getWorld().spigot().playEffect(subLocation, Effect.SNOW_SHOVEL, 0, 0, 1, 1, 1, 1, 10, 64);

                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        if (!onlinePlayer.equals(player) && onlinePlayer.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR &&
                                onlinePlayer.getLocation().distanceSquared(player.getLocation()) <= RADIUS_SQUARED) {
                            onlinePlayer.setVelocity(player.getLocation().getDirection().multiply(-1));
                            onlinePlayer.damage(8, player);
                        }
                    }
                }
                else {
                    cancel();
                }
            }

        }.runTaskTimer(Wizards.getInstance(), 0L, 1L);
    }
}
