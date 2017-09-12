package me.backend.reclaim;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class SetRank implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setrank")) {
			if(!p.hasPermission("command.setrank")) {
				p.sendMessage(ChatColor.RED + "You do not have permission to do this!");
				return false;
			}
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "Usage: /setrank <player> <rank>");
				return false;
			}
			if(args.length == 1) {
				p.sendMessage(ChatColor.RED + "Usage: /setrank <player> <rank>");
				return false;
			}
			if(args.length == 2) {
				Player t = Bukkit.getPlayer(args[0]);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + t.getName() + " group set " + args[1]);
				p.sendMessage(ChatColor.GOLD + "[Kihar] " + ChatColor.GREEN + "You have set the rank of " + t.getName() + " to " + args[1]);
				return false;
			} else {
				p.sendMessage(ChatColor.RED + "Usage: /setrank <player> <rank>");
				return false;
			}
		}
		return true;
	}

}
