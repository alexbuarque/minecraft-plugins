package com.metrotnx.firstPlugin;

import java.util.Calendar;
import java.util.Date;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerCommand implements CommandExecutor{

	private Main main;
	
	public ServerCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(args.length == 1) {
				int action;
				
				try {
					action = Integer.parseInt(args[0]);
				} catch(NumberFormatException e) {
					player.sendMessage(ChatColor.RED + "Instrução inválida!");
					return false;
				}
				
				switch(action) {
				case 1: //kicking
					
					player.kickPlayer("Você foi kickado por:\n" + ChatColor.RED + "Spam");
					
					break;
				case 2: //banning
					
					Bukkit.getBanList(Type.NAME).addBan(player.getName(), "Você foi banido por:\n" + ChatColor.RED + "Uso de hack", null, null);
					
					break;
				case 3: //temp banning
					Calendar cal = Calendar.getInstance();
					
					cal.set(2020, 1, 11);
					
					Date date = cal.getTime();
					
					Bukkit.getBanList(Type.NAME).addBan(player.getName(), "Você foi temporariamente banido por:\n" + ChatColor.RED + "Uso de hack", date, null);
					
					break;
				default:
					return false;
				}
			} else {
				player.sendMessage(ChatColor.RED + "Instrução inválida!");
			}
		}else {
			System.out.println("Esse comando só pode ser usado no jogo!");
		}
		
		return false;
		
	}
	
}
