package de.craplezz.wizards.kit.kits;

import de.craplezz.wizards.kit.Kit;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Color;

/**
 * @author Overload
 * @version 1.0
 */
public class Air extends Kit {

    public Air() {
        super(0, "Luft");

        armorItems[HELMET] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.HELMET).dye(Color.YELLOW).unbreakable().build();
        armorItems[CHESTPLATE] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.CHESTPLATE).dye(Color.YELLOW).unbreakable().build();
        armorItems[LEGGINGS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.LEGGINGS).dye(Color.YELLOW).unbreakable().build();
        armorItems[BOOTS] = ItemBuilders.armor(ItemBuilders.LeatherArmorItemBuilder.ArmorElement.BOOTS).dye(Color.YELLOW).unbreakable().build();
    }

}
