package com.metrotnx.firstPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		System.out.println("TEST PLUGIN ENABLED!");
		
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("number").setExecutor(new NumberCommand());
	}
	
	@Override
	public void onDisable() {
		System.out.println("TEST PLUGIN DISABLED!");
	}
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(!p.hasPermission("firstPlugin.allowmove")) {
			//e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onThrow(PlayerEggThrowEvent e) {
		Player p = e.getPlayer();
		
	    p.sendMessage(ChatColor.RED + "Jogou o Ovo!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if(cmd.getName().equals("hello")){
			if(sender instanceof Player) {
				
				
				player.sendMessage(ChatColor.GRAY + "Hello" + ChatColor.GREEN + player.getName() + ChatColor.GRAY + "Você tem poderes de cura!");
				player.setHealth(20);
				
			}  else {
				System.out.println("You cannot use this command through console!");
			}
		}else if(cmd.getName().equals("config")) {
			String word = this.getConfig().getString("Word");
			int number = this.getConfig().getInt("Number");
			
			player.sendMessage(ChatColor.GRAY + "A palavra é " + ChatColor.GREEN + word + ChatColor.GRAY + " and the number " + ChatColor.YELLOW + number);
			
		}
		
		return false;
	}
}
