package com.metrotnx.firstPlugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		if(e.getBlockPlaced().getType().equals(Material.WOOL)) {
			e.getBlockPlaced().setType(Material.LAVA);
		}
		
		//e.getPlayer().getWorld();
		
	}
	
}
