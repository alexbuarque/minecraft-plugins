package com.metrotnx.firstPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignListener implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		
		Player player = e.getPlayer();
		
		if(e.getLine(0).equals("123")) {
			e.setLine(1, "456");
			e.setLine(2, "789");
			e.setLine(3, "101112");
		}
		
		for(int i = 0; i < 4; i++) {
			String line = e.getLine(i);
			if(line != null && !line.equals("")) {
				e.setLine(i, ChatColor.translateAlternateColorCodes('&', line));
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if(e.getClickedBlock() != null && (e.getClickedBlock().getType().equals(Material.WALL_SIGN) || e.getClickedBlock().getType().equals(Material.SIGN_POST))) {
			player.sendSignChange(e.getClickedBlock().getLocation(), new String[]{"Alo", "Testando o", "Plugin de ", "Placas loucas"});
		}
	}
	
}
