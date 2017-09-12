package me.backend.reclaim;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.customhcf.hcf.HCF;
import com.customhcf.hcf.faction.type.PlayerFaction;

import net.md_5.bungee.api.ChatColor;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerInfo implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("playerinfo")) {
			if(!p.hasPermission("command.playerinfo")) {
				p.sendMessage(ChatColor.RED + "You do not have permission to do that!");
				return false;
			}
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "Usage: /playerinfo <player>");
				return false;
			}
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				PlayerFaction faction = HCF.getPlugin().getFactionManager().getPlayerFaction(t.getUniqueId());
				if(p.hasPermission("playerinfo.helper")) {
					p.sendMessage(ChatColor.RED + "Name: " +t.getName());
					try {
					p.sendMessage(ChatColor.RED + "Faction: " + faction.getDisplayName(p));
					} catch (Exception e) {
						p.sendMessage(ChatColor.RED + "Faction: None");
					}
					try {
						p.sendMessage(ChatColor.RED + "Deathban: " + HCF.getPlugin().getUserManager().getUser(t.getUniqueId()).getDeathban());
					} catch (Exception e) {
						p.sendMessage(ChatColor.RED + "Deathban: None");
					}
					p.sendMessage(ChatColor.RED + "Kills: " + HCF.getPlugin().getUserManager().getUser(t.getUniqueId()).getKills());
					p.sendMessage(ChatColor.RED + "Deaths: " + HCF.getPlugin().getUserManager().getUser(t.getUniqueId()).getDeaths());
					try {
						p.sendMessage(ChatColor.RED + "Last Faction Left: " + HCF.getPlugin().getUserManager().getUser(t.getUniqueId()).getLastFactionLeaveMillis());
					} catch (Exception e) {
						p.sendMessage(ChatColor.RED + "Last Faction Left: None");
					}
						p.sendMessage(ChatColor.RED + "Balance: " + HCF.getPlugin().getEconomyManager().getBalance(t.getUniqueId()));
				}
			return false;
			} else {
				p.sendMessage(ChatColor.RED + "Usage: /playerinfo <player>");
				return false;
			}
		}
		return true;
	}

}
