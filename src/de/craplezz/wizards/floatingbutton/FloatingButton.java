package de.craplezz.wizards.floatingbutton;

import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Schuckmann on 28.05.2016.
 */
public abstract class FloatingButton extends FloatingText {

    public FloatingButton(Location location) {
        super(location);
    }

    @Override
    protected void internalSpawn() {
        super.internalSpawn();
        armorStand.setMarker(false);
    }

    @Override
    protected void internalUpdate() {
        super.internalUpdate();
        armorStand.setHelmet(ItemBuilders.normal(Material.STONE).build());
    }

    public abstract void onClick(Player player);

    public abstract ItemStack getHelmet(Player player);

}
