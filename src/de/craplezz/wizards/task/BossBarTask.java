package de.craplezz.wizards.task;

import de.craplezz.wizards.item.SpecialItem;
import de.craplezz.wizards.item.SpecialItemType;
import de.craplezz.wizards.user.User;
import gnu.trove.procedure.TObjectIntProcedure;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Overload
 * @version 1.0
 */
public class BossBarTask extends BukkitRunnable {

    private Map<User, Map<SpecialItemType, BossBar>> bossBars = new HashMap<>();

    @Override
    public void run() {
        for (SpecialItemType specialItemType : SpecialItemType.values()) {
            SpecialItem specialItem = specialItemType.getSpecialItem();
            specialItem.getCooldowns().forEachEntry(new TObjectIntProcedure<User>() {

                @Override
                public boolean execute(User user, int i) {
                    BossBar bossBar = null;
                    if (bossBars.get(user) != null) {
                        bossBar = bossBars.get(user).get(specialItemType);
                    }
                    else {
                        bossBars.put(user, new HashMap<>());
                    }
                    if (i >= 0) {
                        if (bossBar == null) {
                            bossBar = Bukkit.createBossBar(specialItem.getItemStack().getItemMeta().getDisplayName(), user.getKitType().getKit().getBarColor(), BarStyle.SEGMENTED_20);
                            bossBars.get(user).put(specialItemType, bossBar);
                        }
                        bossBar.addPlayer(user.getPlayer());
                        bossBar.setProgress(i / specialItem.getInitialCooldown());
                    }
                    else if (bossBar != null) {
                        bossBar.removeAll();
                        bossBars.get(user).remove(specialItemType);
                    }
                    return false;
                }

            });
        }
    }

}
