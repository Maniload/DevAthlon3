package de.craplezz.wizards.listener.player;

import de.craplezz.wizards.Wizards;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.function.Consumer;

/**
 * Created by Schuckmann on 29.05.2016.
 */
public class PlayerInteractAtEntityListener implements Listener {

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Consumer<Player> consumer;
        if (event.getRightClicked() instanceof ArmorStand && (consumer = Wizards.getArmorStandManager().getListener(((ArmorStand) event.getRightClicked()))) != null) {
            consumer.accept(player);
        }
        event.setCancelled(true);
    }

}
