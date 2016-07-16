package de.craplezz.wizards.kit.kits;

import de.craplezz.wizards.kit.Kit;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;

/**
 * @author Overload
 * @version 1.0
 */
public class Earth extends Kit {

    public Earth() {
        super(1, "Erde", BarColor.GREEN);

        armorItems[HELMET] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.HELMET).dye(Color.GREEN).unbreakable().build();
        armorItems[CHESTPLATE] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.CHESTPLATE).dye(Color.GREEN).unbreakable().build();
        armorItems[LEGGINGS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.LEGGINGS).dye(Color.GREEN).unbreakable().build();
        armorItems[BOOTS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.BOOTS).dye(Color.GREEN).unbreakable().build();
    }

}
