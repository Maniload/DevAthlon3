package de.craplezz.wizards.kit;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Overload
 * @version 1.0
 */
public abstract class Kit {

    /**
     * Constants for the armor slots
     */
    protected static final int HELMET = 0;
    protected static final int CHESTPLATE = 1;
    protected static final int LEGGINGS = 2;
    protected static final int BOOTS = 3;

    /**
     * Stores all kit by id.
     */
    private static final TIntObjectMap<Kit> kitsById = new TIntObjectHashMap<>();

    /**
     * The id of the kit.
     */
    protected final int id;

    /**
     * The name of the kit as an language key.
     * Should be defined in the locales of the game mode.
     */
    protected final String nameKey;

    /**
     * The description of the kit as an language key.
     * Should be defined in the locales of the game mode.
     */
    protected final String descriptionKey;

    /**
     * Used to represent the kit in an inventory such as a kit chooser.
     */
    protected final ItemStack inventoryIcon;

    /**
     * The items that are added to the player's inventory not including the armor.
     */
    protected final ItemStack[] inventoryItems = new ItemStack[36];

    /**
     * The items that are added to the player's armor slots.<br>
     * Indexes are like this:
     * <ol>
     *      <li>Helmet</li>
     *      <li>Chestplate</li>
     *      <li>Leggings</li>
     *      <li>Boots</li>
     * </ol>
     */
    protected final ItemStack[] armorItems = new ItemStack[4];

    /**
     * The potion effects that are added to the player.
     */
    protected final Set<PotionEffect> potionEffects = new HashSet<>();

    public Kit(int id, String nameKey, String descriptionKey, ItemStack inventoryIcon) {
        this.id = id;
        this.nameKey = nameKey;
        this.descriptionKey = descriptionKey;
        this.inventoryIcon = inventoryIcon;

        kitsById.put(id, this);
    }

    /**
     * Applies the kit with the specific level to the specific player.
     *
     * @param player The player which gets the kit.
     * @param level The level of the kit.
     */
    public void apply(Player player, int level) {
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

    /**
     * Only used to set the items to the specific inventory. Can be used for NPCs, the player can be used
     * for user specific operations.
     *
     * @param player A player reference that should see the items. (Example use: Per player NPCs)
     * @param inventory The inventory in which the items will be added.
     * @param equipment The entity equipment on which the armor will be applied.
     */
    public void applyItems(Player player, PlayerInventory inventory, EntityEquipment equipment) {
        // Set inventory
        inventory.setContents(inventoryItems);

        // Set armor after reversing it
        ItemStack[] armorItemsCopy = new ItemStack[4];
        System.arraycopy(armorItems, 0, armorItemsCopy, 0, 4);
        ArrayUtils.reverse(armorItemsCopy);
        equipment.setArmorContents(armorItemsCopy);
    }

    /**
     * Adds the specific item to the specific slot.
     *
     * @param slot The slot on which the item will be added.
     * @param itemStack The item which will be added.
     */
    protected final void addInventoryItem(int slot, ItemStack itemStack) {
        if (slot >= 0 && slot < 36) {
            inventoryItems[slot] = itemStack;
        }
    }

    /**
     * Adds the specific armor item to the specific slot.
     *
     * @param slot The slot on which the item will be added.
     * @param itemStack The item which will be added.
     */
    protected final void addArmorItem(int slot, ItemStack itemStack) {
        if (slot >= 0 && slot < 4) {
            armorItems[slot] = itemStack;
        }
    }

    /**
     * Adds the specific potion effect.
     *
     * @param potionEffect The potion effect that will be added.
     */
    protected final void addPotionEffect(PotionEffect potionEffect) {
        potionEffects.add(potionEffect);
    }

    /**
     * Gets the kit from the specific id. Or null if no kit has that id.
     *
     * @param id The id of the kit.
     * @return The kit from that id or null.
     */
    public static Kit getById(int id) {
        return kitsById.get(id);
    }

}
