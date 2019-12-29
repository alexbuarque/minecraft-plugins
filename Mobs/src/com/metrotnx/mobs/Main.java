package com.metrotnx.mobs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		Entity ent = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 0, 0, 0), EntityType.ZOMBIE);
		
		//ent.teleport(new Location(world, x, y, z));
		//ent.getLocation().getX();
		//ent.setGravity(false);
		//ent.setInvulnerable(true);
		//ent.isInvulnerable();
		
		//20 ticks = 1 segundo
		
		//ent.setFireTicks(100);
		
		Zombie zombie = (Zombie) ent;
		//zombie.setTarget(ent);
		
		ent.remove();
	}
	
	@EventHandler
	public void entity(EntityDeathEvent e) {
		e.getDrops();
	}
}
