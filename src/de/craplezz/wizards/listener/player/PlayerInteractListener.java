package de.craplezz.wizards.listener.player;

import de.craplezz.wizards.item.SpecialItemType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
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
        Block block = event.getClickedBlock();

        if (event.getAction() != Action.PHYSICAL && itemStack != null) {
            for (SpecialItemType specialItemType : SpecialItemType.values()) {
                if (specialItemType.getSpecialItem().getItemStack().getType() == itemStack.getType()) {
                    specialItemType.getSpecialItem().use(event.getPlayer());
                }
            }

            // Block fire breaking
            if (event.getAction() == Action.LEFT_CLICK_BLOCK && block != null && block.getRelative(BlockFace.UP).getType() == Material.FIRE) {
                event.setCancelled(true);
            }
        }

    }

}
