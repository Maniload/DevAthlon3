package de.craplezz.wizards.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @author Overload
 * @version 1.0
 */
public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        event.setDeathMessage("");
        event.setKeepLevel(true);
        event.setKeepInventory(true);

        event.getEntity().kickPlayer("§7Du bist gestorben.");

    }

}
