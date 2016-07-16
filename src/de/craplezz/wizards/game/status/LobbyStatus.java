package de.craplezz.wizards.game.status;

import com.google.common.collect.Sets;
import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.game.GameState;
import de.craplezz.wizards.game.GameStatus;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * @author Overload
 * @version 1.0
 */
public class LobbyStatus extends GameStatus {

    public LobbyStatus() {
        super(30, Sets.newHashSet(30, 15, 10, 5, 4, 3, 2, 1));
    }

    @Override
    public void onEnter() {

    }

    @Override
    public void onLeave() {

    }

    @Override
    public void onCountdownFinished() {
        if (Wizards.getGame().canStart()) {
            Wizards.getGame().changeGameState(GameState.IN_GAME);
        }
        else {
            reset();
        }
    }

    @Override
    public void tickSecond() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setExp(counter / initialCounter);
            player.setLevel(counter);
        }
    }

    @Override
    public void tickBroadcast() {
        Wizards.broadcast(counter == 1 ? "lobby-tick-one" : "lobby-tick", counter);

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASEDRUM, 1f, 1f);
        }
    }
}
