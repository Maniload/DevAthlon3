package de.craplezz.wizards.kit.kits;

import de.craplezz.wizards.kit.Kit;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;

/**
 * @author Overload
 * @version 1.0
 */
public class Fire extends Kit {

    public Fire() {
        super(2, "Feuer", BarColor.RED);

        armorItems[HELMET] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.HELMET).dye(Color.RED).unbreakable().build();
        armorItems[CHESTPLATE] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.CHESTPLATE).dye(Color.RED).unbreakable().build();
        armorItems[LEGGINGS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.LEGGINGS).dye(Color.RED).unbreakable().build();
        armorItems[BOOTS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.BOOTS).dye(Color.RED).unbreakable().build();
    }

}
