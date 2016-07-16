package de.craplezz.wizards.game;

import de.craplezz.wizards.Wizards;
import org.bukkit.Bukkit;

/**
 * @author Overload
 * @version 1.0
 */
public class Game {

    private GameState gameState = GameState.LOBBY;

    public boolean isLobby() {
        return gameState == GameState.LOBBY;
    }

    public boolean isIngame() {
        return gameState == GameState.IN_GAME;
    }

    public boolean isEnded() {
        return gameState == GameState.END;
    }

    public boolean canStart() {
        return Bukkit.getOnlinePlayers().size() >= Wizards.getMainConfig().getNeededPlayers();
    }

    public void startGame() {
        gameState.getGameStatus().startCountdown();
    }

}
