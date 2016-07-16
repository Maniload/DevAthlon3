package de.craplezz.wizards.listener.player;

import de.craplezz.wizards.item.SpecialItemType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Overload
 * @version 1.0
 */
public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        ItemStack itemStack = event.getItem();

        if (event.getAction() != Action.PHYSICAL && itemStack != null) {
            for (SpecialItemType specialItemType : SpecialItemType.values()) {
                if (specialItemType.getSpecialItem().getItemStack().getType() == itemStack.getType()) {
                    specialItemType.getSpecialItem().use(event.getPlayer());
                }
            }
        }

    }

}
