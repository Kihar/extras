package me.backend.reclaim;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.customhcf.hcf.HCF;

public class Reclaim extends JavaPlugin {
	
	Config config = new Config(this, "config");
	Config donators = new Config(this, "donators");
	
	public void onEnable() {
		getCommand("monkey").setExecutor(new Monkey());
		getCommand("setrank").setExecutor(new SetRank());
		getCommand("playerinfo").setExecutor(new PlayerInfo());
		
		Bukkit.getPluginManager().registerEvents(new JoinLeaveEvent(), this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("reclaim") || cmd.getName().equalsIgnoreCase("claim")) {
			if(p.hasPermission("claim.basic")) {
				if(donators.get("basicreclaims." + p.getUniqueId()) != null) {
					p.sendMessage(ChatColor.RED + "You have already reclaimed!");
					return false;
				}
				for (String basicItems : config.getStringList("basiccmds")) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), basicItems.replace("%player%", p.getName()));				}
				donators.set("basicreclaims." + p.getUniqueId(), true);
				donators.save();
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("basic-broadcast").replace("%player%", p.getName()).replace("%rank%", "Basic")));

				return false;
			}
			if(p.hasPermission("claim.gold")) {
				if(donators.get("goldreclaims." + p.getUniqueId()) != null) {
					p.sendMessage(ChatColor.RED + "You have already reclaimed!");
					return false;
				}
				for (String goldItems : config.getStringList("goldcmds")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), goldItems.replace("%player%", p.getName()));
				}
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("gold-broadcast").replace("%player%", p.getName()).replace("%rank%", "Gold")));
				donators.set("goldreclaims." + p.getUniqueId(), true);
				donators.save();
				return false;
			}
			if(p.hasPermission("claim.platinum")) {
				if(donators.get("platreclaims." + p.getUniqueId()) != null) {
					p.sendMessage(ChatColor.RED + "You have already reclaimed!");
					return false;
				}
				for (String platItems : config.getStringList("platcmds")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), platItems.replace("%player%", p.getName()));
				}
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("plat-broadcast").replace("%player%", p.getName()).replace("%rank%", "Platinum")));
				donators.set("platreclaims." + p.getUniqueId(), true);
				donators.save();
				return false;
			}
			if(p.hasPermission("claim.partner")) {
				if(donators.get("partnersreclaims." + p.getUniqueId()) != null) {
					p.sendMessage(ChatColor.RED + "You have already reclaimed!");
					return false;
				}
				for (String platItems : config.getStringList("partnercmds")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), platItems.replace("%player%", p.getName()));
				}
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("partner-broadcast").replace("%player%", p.getName()).replace("%rank%", "Partner")));
				donators.set("partnerreclaims." + p.getUniqueId(), true);
				donators.save();
				return false;
			}
			if(p.hasPermission("claim.youtube")) {
				if(donators.get("youtubereclaims." + p.getUniqueId()) != null) {
					p.sendMessage(ChatColor.RED + "You have already reclaimed!");
					return false;
				}
				for (String platItems : config.getStringList("youtubecmds")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), platItems.replace("%player%", p.getName()));
				}
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("youtube-broadcast").replace("%player%", p.getName()).replace("%rank%", "YouTube")));
				donators.set("youtubereclaims." + p.getUniqueId(), true);
				donators.save();
				return false;
			}
			if(p.hasPermission("claim.famous")) {
				if(donators.get("famousreclaims." + p.getUniqueId()) != null) {
					p.sendMessage(ChatColor.RED + "You have already reclaimed!");
					return false;
				}
				for (String platItems : config.getStringList("famouscmds")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), platItems.replace("%player%", p.getName()));
				}
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("famous-broadcast").replace("%player%", p.getName()).replace("%rank%", "Famous")));
				donators.set("famousreclaims." + p.getUniqueId(), true);
				donators.save();
				return false;
			}
			if(p.hasPermission("claim.kihar")) {
				if(donators.get("kiharreclaims." + p.getUniqueId()) != null) {
					p.sendMessage(ChatColor.RED + "You have already reclaimed!");
					return false;
				}
				for (String platItems : config.getStringList("kiharcmds")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), platItems.replace("%player%", p.getName()));
				}
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("kihar-broadcast").replace("%player%", p.getName()).replace("%rank%", "Kihar")));
				donators.set("kiharreclaims." + p.getUniqueId(), true);
				donators.save();
				return false;
			}
			if(p.hasPermission("claim.medic")) {
				if(donators.get("medicreclaims." + p.getUniqueId()) != null) {
					p.sendMessage(ChatColor.RED + "You have already reclaimed!");
					return false;
				}
				for (String platItems : config.getStringList("mediccmds")) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), platItems.replace("%player%", p.getName()));
				}
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("medic-broadcast").replace("%player%", p.getName()).replace("%rank%", "Medic")));
				donators.set("medicreclaims." + p.getUniqueId(), true);
				donators.save();
				return false;
			} else {
				p.sendMessage(ChatColor.RED + "You do not have anything to reclaim!");
				return false;
			}
		}
		return true;
	}

}
