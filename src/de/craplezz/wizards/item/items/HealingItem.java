package de.craplezz.wizards.item.items;

import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

/**
 * @author Overload
 * @version 1.0
 */
public class HealingItem extends SpecialItem {

    public HealingItem() {
        super(ItemBuilders.potion().effect(new Potion(PotionType.INSTANT_HEAL)).name("§bHeilung §7(10 Sek. Cooldown)").build(), 200);
    }

    @Override
    protected void internalUse(Player player) {
        player.setHealth(Math.min(player.getMaxHealth(), player.getHealth() + 10));
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
    }
}
