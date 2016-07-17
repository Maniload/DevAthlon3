package de.craplezz.wizards.kit.kits;

import de.craplezz.wizards.item.SpecialItemType;
import de.craplezz.wizards.kit.Kit;
import de.craplezz.wizards.util.InfinitePotionEffect;
import de.craplezz.wizards.util.ItemBuilders;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;
import org.bukkit.potion.PotionEffectType;

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

        inventoryItems[3] = SpecialItemType.FIRE_TRAIL.getSpecialItem().getItemStack();
        inventoryItems[3] = SpecialItemType.METEOR.getSpecialItem().getItemStack();

        potionEffects.add(new InfinitePotionEffect(PotionEffectType.FIRE_RESISTANCE, 0));
    }

}
