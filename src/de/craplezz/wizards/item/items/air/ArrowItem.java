package de.craplezz.wizards.item.items.air;

import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TippedArrow;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

/**
 * @author Overload
 * @version 1.0
 */
public class ArrowItem extends SpecialItem {

    public ArrowItem() {
        super(ItemBuilders.normal(Material.ARROW).name("§bPfeile §7(10 Sek. Cooldown)").build(), 200);
    }

    @Override
    protected void internalUse(Player player) {
        TippedArrow arrow = player.launchProjectile(TippedArrow.class);
        arrow.setBasePotionData(new PotionData(PotionType.SLOWNESS));
    }
}
