package de.craplezz.wizards.item;

import de.craplezz.wizards.item.items.FeatherItem;
import de.craplezz.wizards.item.items.HealingItem;
import de.craplezz.wizards.item.items.WandItem;
import de.craplezz.wizards.item.items.air.ArrowItem;
import de.craplezz.wizards.item.items.air.LightningItem;
import de.craplezz.wizards.item.items.earth.PoisonTrailItem;
import de.craplezz.wizards.item.items.earth.ShockwaveItem;
import de.craplezz.wizards.item.items.fire.FireTrailItem;
import de.craplezz.wizards.item.items.fire.MeteorItem;
import de.craplezz.wizards.item.items.water.IceSnakeItem;
import de.craplezz.wizards.item.items.water.WaterGunItem;

/**
 * @author Overload
 * @version 1.0
 */
public enum SpecialItemType {
    WAND (new WandItem()),
    FEATHER (new FeatherItem()),
    HEALING (new HealingItem()),
    ARROW (new ArrowItem()),
    LIGHTNING (new LightningItem()),
    POISON_TRAIL (new PoisonTrailItem()),
    SHOCKWAVE (new ShockwaveItem()),
    FIRE_TRAIL (new FireTrailItem()),
    METEOR (new MeteorItem()),
    ICE_SNAKE (new IceSnakeItem()),
    WATER_GUN (new WaterGunItem());

    private SpecialItem specialItem;

    SpecialItemType(SpecialItem specialItem) {
        this.specialItem = specialItem;
    }

    public SpecialItem getSpecialItem() {
        return specialItem;
    }
}
