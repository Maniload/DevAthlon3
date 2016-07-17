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
public class Air extends Kit {

    public Air() {
        super(0, "Luft", BarColor.YELLOW);

        armorItems[HELMET] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.HELMET).dye(Color.YELLOW).unbreakable().build();
        armorItems[CHESTPLATE] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.CHESTPLATE).dye(Color.YELLOW).unbreakable().build();
        armorItems[LEGGINGS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.LEGGINGS).dye(Color.YELLOW).unbreakable().build();
        armorItems[BOOTS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.BOOTS).dye(Color.YELLOW).unbreakable().build();

        inventoryItems[2] = SpecialItemType.ARROW.getSpecialItem().getItemStack();
        inventoryItems[3] = SpecialItemType.LIGHTNING.getSpecialItem().getItemStack();
    }

}
