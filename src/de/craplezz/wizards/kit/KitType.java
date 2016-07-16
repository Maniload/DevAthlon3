package de.craplezz.wizards.kit;

import de.craplezz.wizards.kit.kits.Air;
import de.craplezz.wizards.kit.kits.Earth;
import de.craplezz.wizards.kit.kits.Fire;
import de.craplezz.wizards.kit.kits.Water;

/**
 * @author Overload
 * @version 1.0
 */
public enum KitType {
    AIR (new Air()),
    EARTH (new Earth()),
    FIRE (new Fire()),
    WATER (new Water());

    private Kit kit;

    KitType(Kit kit) {
        this.kit = kit;
    }

    public Kit getKit() {
        return kit;
    }

}
