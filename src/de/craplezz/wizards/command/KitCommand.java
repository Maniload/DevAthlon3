package de.craplezz.wizards.command;

import de.craplezz.wizards.kit.KitType;
import de.craplezz.wizards.user.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Overload
 * @version 1.0
 */
public class KitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if (args.length == 1) {
            KitType kitType = KitType.values()[Integer.parseInt(args[0])];
            User.getUser((Player) commandSender).changeKit(kitType);
        }

        return true;
    }

}
