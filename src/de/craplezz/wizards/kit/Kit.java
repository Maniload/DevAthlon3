package de.craplezz.wizards.kit;

import de.craplezz.wizards.util.ItemBuilders;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Overload
 * @version 1.0
 */
public abstract class Kit {

    protected static final int HELMET = 0;
    protected static final int CHESTPLATE = 1;
    protected static final int LEGGINGS = 2;
    protected static final int BOOTS = 3;

    private static final TIntObjectMap<Kit> kitsById = new TIntObjectHashMap<>();

    protected final int id;

    protected final String name;

    protected final BarColor barColor;

    protected final ItemStack[] inventoryItems = new ItemStack[36];

    protected final ItemStack[] armorItems = new ItemStack[4];

    protected final Set<PotionEffect> potionEffects = new HashSet<>();

    public Kit(int id, String name, BarColor barColor) {
        this.id = id;
        this.name = name;
        this.barColor = barColor;

        kitsById.put(id, this);

        // Default item
        inventoryItems[0] = ItemBuilders.normal(Material.STICK).name("item-stick").build();
        inventoryItems[6] = ItemBuilders.normal(Material.FEATHER).name("item-feather").build();
        inventoryItems[7] = ItemBuilders.potion().effect(new Potion(PotionType.INSTANT_HEAL)).name("item-healing").build();
        inventoryItems[8] = ItemBuilders.normal(Material.COMPASS).name("item-compass").build();
    }

    public void apply(Player player) {
        // Clear old Inventory and remove potion effects
        player.getInventory().clear();
        player.getEquipment().clear();
        for (PotionEffect potionEffect : player.getActivePotionEffects()) {
            player.removePotionEffect(potionEffect.getType());
        }

        applyItems(player, player.getInventory(), player.getEquipment());

        // Apply potion effects
        for (PotionEffect potionEffect : potionEffects) {
            potionEffect.apply(player);
        }

        // Update
        player.updateInventory();
    }

    public void applyItems(Player player, PlayerInventory inventory, EntityEquipment equipment) {
        // Set inventory
        inventory.setContents(inventoryItems);

        // Set armor after reversing it
        ItemStack[] armorItemsCopy = new ItemStack[4];
        System.arraycopy(armorItems, 0, armorItemsCopy, 0, 4);
        ArrayUtils.reverse(armorItemsCopy);
        equipment.setArmorContents(armorItemsCopy);
    }

    public void apply(ArmorStand armorStand) {
        // Set armor after reversing it
        ItemStack[] armorItemsCopy = new ItemStack[4];
        System.arraycopy(armorItems, 0, armorItemsCopy, 0, 4);
        ArrayUtils.reverse(armorItemsCopy);

        armorStand.getEquipment().setArmorContents(armorItemsCopy);
        armorStand.setItemInHand(inventoryItems[0]);
    }

    protected final void addInventoryItem(int slot, ItemStack itemStack) {
        if (slot >= 0 && slot < 36) {
            inventoryItems[slot] = itemStack;
        }
    }

    protected final void addArmorItem(int slot, ItemStack itemStack) {
        if (slot >= 0 && slot < 4) {
            armorItems[slot] = itemStack;
        }
    }

    protected final void addPotionEffect(PotionEffect potionEffect) {
        potionEffects.add(potionEffect);
    }

    public String getName() {
        return name;
    }

    public BarColor getBarColor() {
        return barColor;
    }

    public static Kit getById(int id) {
        return kitsById.get(id);
    }

}
