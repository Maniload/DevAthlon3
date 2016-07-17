package de.craplezz.wizards.listener.player;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.user.User;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.TippedArrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

/**
 * @author Overload
 * @version 1.0
 */
public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        User user = User.getUser(event.getPlayer());

        if (user.hasFireTrail() && event.getFrom().getBlock().getRelative(BlockFace.DOWN).getType().isSolid()) {
            event.getFrom().getBlock().setType(Material.FIRE);

            event.getFrom().getWorld().playSound(event.getFrom(), Sound.ENTITY_FIREWORK_BLAST, 1f, 1f);

            Bukkit.getScheduler().runTaskLater(Wizards.getInstance(), new Runnable() {

                @Override
                public void run() {
                    if (event.getFrom().getBlock().getType() == Material.FIRE) {
                        event.getFrom().getBlock().setType(Material.AIR);
                    }
                }

            }, 100L);
        }

        if (user.hasPoisonTrail()) {
            TippedArrow arrow = event.getPlayer().launchProjectile(TippedArrow.class, event.getPlayer().getLocation().getDirection().multiply(-1));
            arrow.setBasePotionData(new PotionData(PotionType.POISON));
        }
    }

}
