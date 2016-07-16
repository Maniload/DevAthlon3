package de.craplezz.wizards.floatingbutton;

import de.craplezz.wizards.user.User;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Overload
 * @version 1.0
 */
public abstract class FloatingArmorStand extends FloatingButton {

    private String nameKey;

    public FloatingArmorStand(ArmorStand armorStand, String nameKey) {
        super(armorStand.getLocation());
        this.armorStand = armorStand;
        this.nameKey = nameKey;
    }

    @Override
    public abstract void onClick(Player player);

    @Override
    public ItemStack getHelmet(Player player) {
        return armorStand.getHelmet();
    }

    @Override
    public String getDisplayName(Player player) {
        User user = User.getUser(player);
        return user.getMessage(nameKey);
    }

    @Override
    protected void internalSpawn() {}
}
