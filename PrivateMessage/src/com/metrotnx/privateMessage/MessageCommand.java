package com.metrotnx.privateMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

	private Main main;
	
	public MessageCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(args.length >= 2) {
				if(Bukkit.getPlayerExact(args[0]) != null) {
					Player target = Bukkit.getPlayerExact(args[0]);
					
					StringBuilder message = new StringBuilder();
					
					for(int i = 1; i < args.length; i++) {
						message.append(args[i]).append(" ");
					}
					
					main.getMessageManager().sendMessage(player, target, message.toString());
					
					main.getMessageManager().recentlyMessagedFrom.put(target, player);

					
				} else {
					player.sendMessage(ChatColor.RED + "Player não encontrado!");
				}
			} else {
				player.sendMessage(ChatColor.RED + "Uso invalido! Use /message <player> <message>");
			}
			
		} else {
			System.out.println("Comando de chat só pode ser usado no jogo!");
		}
		
		
		
		return false;
	}

}
