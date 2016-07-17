package de.craplezz.wizards.game;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.user.User;
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

    public void changeGameState(GameState newGameState) {
        gameState.getGameStatus().onLeave();
        gameState = newGameState;
        gameState.getGameStatus().onEnter();
    }

    public GameState getGameState() {
        return gameState;
    }

    public boolean canStart() {
        boolean allEquiped = true;
        for (User user : User.getUsers()) {
            if (user.getKitType() == null) {
                allEquiped = false;
            }
        }
        return Bukkit.getOnlinePlayers().size() >= Wizards.getMainConfig().getNeededPlayers() && allEquiped;
    }

    public void startGame() {
        gameState.getGameStatus().startCountdown();
    }

}
