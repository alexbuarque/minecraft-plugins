package com.metrotnx.firstPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class MenuListener implements Listener {

	private Main main;
	
	public MenuListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
		Player player = (Player) e.getWhoClicked();
		
		if(ChatColor.translateAlternateColorCodes('&', e.getClickedInventory().getTitle()).equals(ChatColor.GREEN + "Elytra menu!")) {
			if(e.getCurrentItem() != null) {
				e.setCancelled(true);
				
				switch(e.getCurrentItem().getType()) {
				case WEB:
					player.setVelocity(new Vector(0, 200, 0));
					
					player.sendMessage("Jogado para cima!");
					break;
				case EMERALD_BLOCK:
					if(player.getInventory().getChestplate() != null) {
						main.chestSlot.put(player, player.getInventory().getChestplate().getType());
					}
					
					player.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
					
					player.sendMessage("Elytra habilitada!");
					
					break;
				case REDSTONE_BLOCK:
					if(main.chestSlot.containsKey(player)) {
						player.getInventory().setChestplate(new ItemStack(main.chestSlot.get(player)));
					} else {
						player.getInventory().setChestplate(null);
					}
					
					player.sendMessage("Elytra desabilitada!");
					
					break;
				default:
					return;
				}
			}
			
			player.closeInventory();
		}
	}
	
}
