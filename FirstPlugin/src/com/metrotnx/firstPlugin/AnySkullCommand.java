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

public class AnySkullCommand  implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			//ItemStack skull = new ItemStack(Material.PLAYER_HEAD); //1.13..
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) SkullType.PLAYER.ordinal());
			SkullMeta meta = (SkullMeta) skull.getItemMeta();
			
			GameProfile profile = new GameProfile(UUID.randomUUID(), null);
			profile.getProperties().put("textures", new Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ1ZWFlNmZjZDg0YmI0MjIzN2YwNzZlZjNhNTE0Njk1ZjE0NjE3NDA4NTM2MmI3N2ZlYWQ0NTA2ODY0ZTgifX19"));
			Field field;
			
			try {
				field = meta.getClass().getDeclaredField("profile");
				field.setAccessible(true);
				field.set(meta, profile);
			}catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException x) {
				x.printStackTrace();
			}

			skull.setItemMeta(meta);
			
			player.getInventory().addItem(skull);
		}
		
		return false;
	}
	
}
