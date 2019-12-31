package com.metrotnx.privateMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand implements CommandExecutor {

	private Main main;
	
	public ReplyCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;

			if(args.length > 0) {
			
				if(main.getMessageManager().recentlyMessagedFrom.containsKey(player)) {
					if(main.getMessageManager().recentlyMessagedFrom.get(player) != null) {

						Player target  = main.getMessageManager().recentlyMessagedFrom.get(player);
						System.out.println(target);
						
						StringBuilder message = new StringBuilder();
						for(int i = 0; i < args.length; i++) {
							message.append(args[i]).append(" ");
						}
						
						main.getMessageManager().sendMessage(player, target, message.toString());
						
						main.getMessageManager().recentlyMessagedFrom.put(target, player);
						
					} else {
						player.sendMessage(ChatColor.RED + "O player deslogou!");
					}
				} else {
					player.sendMessage(ChatColor.RED + "Você não recebeu nenhuma mensagem recentemente.");
				}
			} else {
				player.sendMessage(ChatColor.RED + "Uso inválido! Use /reply <message>");
			}
			
		} else {
			System.out.println("Comando de chat só pode ser usado no jogo!");
		}
		
		return false;
	}

}
