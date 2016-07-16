package de.craplezz.wizards.item;

import de.craplezz.wizards.item.items.FeatherItem;
import de.craplezz.wizards.item.items.WandItem;

/**
 * @author Overload
 * @version 1.0
 */
public enum SpecialItemType {
    WAND (new WandItem()),
    FEATHER (new FeatherItem());

    private SpecialItem specialItem;

    SpecialItemType(SpecialItem specialItem) {
        this.specialItem = specialItem;
    }

    public SpecialItem getSpecialItem() {
        return specialItem;
    }
}
