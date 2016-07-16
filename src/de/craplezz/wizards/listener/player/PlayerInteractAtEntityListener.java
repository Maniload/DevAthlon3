package de.craplezz.wizards.listener.player;

import de.craplezz.wizards.floatingbutton.FloatingButton;
import de.craplezz.wizards.floatingbutton.FloatingText;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

/**
 * Created by Schuckmann on 29.05.2016.
 */
public class PlayerInteractAtEntityListener implements Listener {

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        FloatingText floatingText;
        if (event.getRightClicked() instanceof ArmorStand && FloatingText.isFloatingText((ArmorStand) event.getRightClicked()) &&
                (floatingText = FloatingText.getFloatingText((ArmorStand) event.getRightClicked())) instanceof FloatingButton) {
            FloatingButton floatingButton = (FloatingButton) floatingText;
            floatingButton.onClick(player);
        }
        event.setCancelled(true);
    }

}
