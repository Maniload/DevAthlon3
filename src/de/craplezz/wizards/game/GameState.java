package de.craplezz.wizards.game;

import de.craplezz.wizards.game.status.EndStatus;
import de.craplezz.wizards.game.status.IngameStatus;
import de.craplezz.wizards.game.status.LobbyStatus;

/**
 * @author Overload
 * @version 1.0
 */
public enum GameState {
    LOBBY (new LobbyStatus()),
    IN_GAME (new IngameStatus()),
    END (new EndStatus());

    private GameStatus gameStatus;

    GameState(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public GameState getNextGameState() {
        if (values().length <= ordinal()) {
            return values()[ordinal() + 1];
        }
        return null;
    }

}
