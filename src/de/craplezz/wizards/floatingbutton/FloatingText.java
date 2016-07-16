package de.craplezz.wizards.floatingbutton;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

/**
 * Created by Schuckmann on 31.05.2016.
 */
public abstract class FloatingText {

    protected static TIntObjectMap<FloatingText> floatingTexts = new TIntObjectHashMap<>();

    protected Location location;
    protected ArmorStand armorStand;

    public FloatingText(Location location) {
        this.location = location;
    }

    public final void spawn() {
        internalSpawn();
        floatingTexts.put(armorStand.getEntityId(), this);
        update();
    }

    protected void internalSpawn() {
        armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.setCustomNameVisible(true);
        armorStand.setMarker(true);
    }

    public final void update() {
        internalUpdate();
    }

    protected void internalUpdate() {
        armorStand.setCustomName(String.valueOf(System.currentTimeMillis()));
    }

    public final void remove() {
        floatingTexts.remove(armorStand.getEntityId());
        internalRemove();
    }

    protected void internalRemove() {
        armorStand.remove();
    }

    public abstract String getDisplayName(Player player);

    public static FloatingText getFloatingText(ArmorStand armorStand) {
        return getFloatingText(armorStand.getEntityId());
    }

    public static FloatingText getFloatingText(int entityId) {
        return floatingTexts.get(entityId);
    }

    public static boolean isFloatingText(ArmorStand armorStand) {
        return isFloatingText(armorStand.getEntityId());
    }

    public static boolean isFloatingText(int entityId) {
        return floatingTexts.containsKey(entityId);
    }

}
