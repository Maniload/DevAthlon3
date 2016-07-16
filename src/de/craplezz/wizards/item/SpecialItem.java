package de.craplezz.wizards.item;

import de.craplezz.wizards.user.User;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Overload
 * @version 1.0
 */
public abstract class SpecialItem {

    private final ItemStack itemStack;
    private final int initialCooldown;
    private TObjectIntMap<User> cooldowns = new TObjectIntHashMap<>();

    public SpecialItem(ItemStack itemStack, int cooldown) {
        this.itemStack = itemStack;
        this.initialCooldown = cooldown;
    }

    public final boolean use(Player player) {
        if (initialCooldown > 0) {
            User user = User.getUser(player);
            if (cooldowns.containsKey(user)) {
                return false;
            }
            cooldowns.put(user, initialCooldown);
        }
        internalUse(player);
        return true;
    }

    protected abstract void internalUse(Player player);

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getInitialCooldown() {
        return initialCooldown;
    }

    public TObjectIntMap<User> getCooldowns() {
        return cooldowns;
    }
}
