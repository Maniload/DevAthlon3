package de.craplezz.wizards.listener.entity;

import de.craplezz.wizards.Wizards;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.function.Consumer;

/**
 * @author Overload
 * @version 1.0
 */
public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (event.getEntity() instanceof ArmorStand) {
                Consumer<Player> consumer;
                if ((consumer = Wizards.getArmorStandManager().getListener(((ArmorStand) event.getEntity()))) != null) {
                    consumer.accept(player);
                }
                event.setCancelled(true);
            }
        }
    }

}
