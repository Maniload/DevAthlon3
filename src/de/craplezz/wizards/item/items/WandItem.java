package de.craplezz.wizards.item.items;

import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * @author Overload
 * @version 1.0
 */
public class WandItem extends SpecialItem {

    public WandItem() {
        super(ItemBuilders.normal(Material.STICK).name("§bZauberstab §7(20 Sek. Cooldown)").build(), 20);
    }

    @Override
    protected void internalUse(Player player) {
        player.sendMessage("Test");
    }
}
