package de.craplezz.wizards.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * @author Overload
 * @version 1.0
 */
public class PlayerFoodLevelChangeListener implements Listener {

    @EventHandler
    public void onPlayerFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getFoodLevel() < 20) {
            event.setFoodLevel(20);
        }
        else {
            event.setCancelled(true);
        }
    }

}
