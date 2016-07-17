package de.craplezz.wizards.kit.kits;

import de.craplezz.wizards.item.SpecialItemType;
import de.craplezz.wizards.kit.Kit;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;

/**
 * @author Overload
 * @version 1.0
 */
public class Water extends Kit {

    public Water() {
        super(3, "Wasser", BarColor.BLUE);

        armorItems[HELMET] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.HELMET).dye(Color.BLUE).unbreakable().build();
        armorItems[CHESTPLATE] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.CHESTPLATE).dye(Color.BLUE).unbreakable().build();
        armorItems[LEGGINGS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.LEGGINGS).dye(Color.BLUE).unbreakable().build();
        armorItems[BOOTS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.BOOTS).dye(Color.BLUE).unbreakable().build();

        inventoryItems[3] = SpecialItemType.WATER_GUN.getSpecialItem().getItemStack();
        inventoryItems[4] = SpecialItemType.ICE_SNAKE.getSpecialItem().getItemStack();
    }

}
