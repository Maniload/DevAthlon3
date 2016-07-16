package de.craplezz.wizards.listener.player;

import de.craplezz.wizards.Wizards;
import de.craplezz.wizards.user.User;
import org.bukkit.Bukkit;
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

        if (Wizards.getGame().isLobby()) {
            Wizards.broadcast("lobby-join", player.getName());

            player.teleport(Wizards.getMainConfig().getLobbyLocation().toBukkitLocation(Bukkit.getWorld("world")));
        }

    }

}
