package com.metrotnx.firstPlugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor{

	private Main main;
	private List<Player> sumidos = new ArrayList<>();
	
	public VanishCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("vanish")) {
				if(sumidos.contains(player)) {
					sumidos.remove(player);
					for(Player target : Bukkit.getOnlinePlayers()) {
						target.showPlayer(Bukkit.getPluginManager().getPlugin("FirstPlugin"), player);
					}
				} else {
					sumidos.remove(player);
					for(Player target : Bukkit.getOnlinePlayers()) {
						target.hidePlayer(Bukkit.getPluginManager().getPlugin("FirstPlugin"), player);
					}
				}
			}
		}
		
		return false;
		
	}
	
}
