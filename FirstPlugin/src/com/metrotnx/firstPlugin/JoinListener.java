package com.metrotnx.firstPlugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

	private Main main;
	
	public JoinListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		main.bossbar.addPlayer(e.getPlayer());
		
	}
	
}
