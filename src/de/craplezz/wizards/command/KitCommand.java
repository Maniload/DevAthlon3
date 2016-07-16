package de.craplezz.wizards.command;

import de.craplezz.wizards.kit.Kit;
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
            Kit kit = Kit.getById(Integer.valueOf(args[0]));
            kit.apply((Player) commandSender);
        }

        return true;
    }

}
