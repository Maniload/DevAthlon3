package de.craplezz.wizards.listener.player;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.user.User;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Overload
 * @version 1.0
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        event.setJoinMessage("");

        Player player = event.getPlayer();
        User user = new User(player);

        player.setMaxHealth(40);
        player.setHealth(40);

        player.setGameMode(GameMode.ADVENTURE);

        if (Wizards.getGame().isLobby()) {
            Bukkit.broadcastMessage("§d" + player.getName() + " §7hat das Spiel betreten");

            player.teleport(Wizards.getMainConfig().getLobbyLocation().toBukkitLocation(Bukkit.getWorld("world")));

            if (Wizards.getGame().canStart() && !Wizards.getGame().getGameState().getGameStatus().isStarted()) {
                Wizards.getGame().startGame();
            }
        }

    }

}
