package com.metrotnx.firstPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NumberCommand implements CommandExecutor{

	//number <number> <test> <test1>
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args[0].equalsIgnoreCase("1")) {
				p.sendMessage("ONE");
			}else if(args[0].equalsIgnoreCase("2")) {
				p.sendMessage("TWO");
			}else {
				p.sendMessage("INVALID");
			}
		}
		
		
		
		return false;
	}
	
}
