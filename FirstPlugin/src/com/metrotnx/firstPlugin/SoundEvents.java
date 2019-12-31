package com.metrotnx.firstPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SoundEvents implements Listener {

	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		
		e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
		
		//Bukkit.getWorld("world").playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
		
	}
	
}
