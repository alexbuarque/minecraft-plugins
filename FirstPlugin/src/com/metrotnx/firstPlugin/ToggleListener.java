package com.metrotnx.firstPlugin;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ToggleListener implements Listener{

	ArrayList<Player> enabled = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		
		if(player.getItemInHand().getType().equals(Material.NETHER_STAR)) {
			if(enabled.contains(player)) { // IS ENABLED
				
				player.sendMessage("Você desabilitou.");
				enabled.remove(player);
				
			} else { // NOT ENABLED
				
				player.sendMessage("Você habilitou.");
				enabled.add(player);
				
			}
		}
		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if(enabled.contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("Desabilitado");
		}
	}
	
}
