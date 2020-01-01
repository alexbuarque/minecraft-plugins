package com.metrotnx.firstPlugin;

import java.lang.reflect.Field;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class MySkullCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			//ItemStack skull = new ItemStack(Material.PLAYER_HEAD); //1.13..
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
			SkullMeta meta = (SkullMeta) skull.getItemMeta();
			
			meta.setOwningPlayer(player);

			skull.setItemMeta(meta);
			
			player.getInventory().addItem(skull);
		}
		
		return false;
	}

}
