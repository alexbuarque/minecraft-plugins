package com.metrotnx.firstPlugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener{

	@EventHandler
	public void onPing(ServerListPingEvent e) {
		
		e.setMaxPlayers(20000);
		e.setMotd(ChatColor.YELLOW + "Futuro servidor de MazeRunner!" + "\n" + ChatColor.BLUE + "Corra para sua sobrevivencia!");
		
		try {
			e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
		}catch(Exception error) {
			System.out.println("Icone do server não encontrado");
		}
			
		
	}
	
}
