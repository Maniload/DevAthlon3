package de.craplezz.wizards.game.status;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.game.GameStatus;

/**
 * @author Overload
 * @version 1.0
 */
public class IngameStatus extends GameStatus {

    public IngameStatus() {
        super(0, null);
    }

    @Override
    public void onEnter() {
        Wizards.getMap().teleportPlayers();
    }

    @Override
    public void onLeave() {

    }

}
