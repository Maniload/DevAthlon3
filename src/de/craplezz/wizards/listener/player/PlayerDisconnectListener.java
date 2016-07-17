package de.craplezz.wizards.listener.player;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.game.GameState;
import de.craplezz.wizards.user.User;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Overload
 * @version 1.0
 */
public class PlayerDisconnectListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        event.setQuitMessage("");

        User.removeUser(event.getPlayer());

        if (Wizards.getGame().isLobby() || Wizards.getGame().isEnded()) {
            Bukkit.broadcastMessage("§d" + event.getPlayer().getName() + " §7hat das Spiel verlassen");
        }
        else {
            Wizards.broadcastPrefixed("§b" + event.getPlayer().getName() + " §7ist gestorben.");

            if (Wizards.getGame().isIngame() && Bukkit.getOnlinePlayers().size() <= 1) {
                Player winner = Bukkit.getOnlinePlayers().iterator().next();
                User.getUser(winner).sendPrefixedMessage("Du hast gewonnen.");

                winner.playSound(winner.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);

                Wizards.getGame().changeGameState(GameState.END);
            }
        }

    }

}
