package com.metrotnx.firstPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class ResourcePacks implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player player = e.getPlayer();
		System.out.println("Testando resource packs!");
		player.setResourcePack("https://www.planetminecraft.com/texture_pack/faithful-32x32-vanilla-tweaks/download/file/11653937/");
		
	}
	
	@EventHandler
	public void packStatus(PlayerResourcePackStatusEvent e) {
		
		//PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED;
		
	}
	
}
