package de.craplezz.wizards.game.status;

import com.google.common.collect.Sets;
import de.craplezz.wizards.game.GameStatus;

/**
 * @author Overload
 * @version 1.0
 */
public class EndStatus extends GameStatus {

    public EndStatus() {
        super(15, Sets.newHashSet(15, 10, 5, 4, 3, 2, 1));
    }

    @Override
    public void onEnter() {

    }

    @Override
    public void onLeave() {

    }

}
