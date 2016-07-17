package de.craplezz.wizards.item.items.earth;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.user.User;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * @author Overload
 * @version 1.0
 */
public class PoisonTrailItem extends SpecialItem {

    public PoisonTrailItem() {
        super(ItemBuilders.normal(Material.EMERALD).name("§bGift Spur §7(10 Sek. Cooldown)").build(), 200);
    }

    @Override
    protected void internalUse(Player player) {
        User.getUser(player).setPoisonTrail(true);
        Bukkit.getScheduler().runTaskLater(Wizards.getInstance(), new Runnable() {

            @Override
            public void run() {
                User.getUser(player).setPoisonTrail(false);
            }

        }, 100L);
    }
}
