package com.metrotnx.privateMessage;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageManager {

	private Main main;
	
	public HashMap<Player, Player> recentlyMessagedFrom = new HashMap<>();
	
	public MessageManager(Main main) {
		this.main = main;
	}	
	
	public void sendMessage(Player from, Player to, String message) {
		
		from.sendMessage(ChatColor.GREEN + from.getName() + ": " + ChatColor.GRAY + message);
		to.sendMessage(ChatColor.GREEN + from.getName() + ": " + ChatColor.GRAY + message);
		
	}
	
}
