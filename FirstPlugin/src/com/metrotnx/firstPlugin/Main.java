package com.metrotnx.firstPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.EulerAngle;

public class Main extends JavaPlugin implements Listener{

	BossBar bossbar;
	
	//GUI
	public HashMap<Player, Material> chestSlot = new HashMap<>();
	
	@Override
	public void onEnable() {
		System.out.println("TEST PLUGIN ENABLED!");
		
		//Icone, qtd Players e mensagem do servidor
		Bukkit.getPluginManager().registerEvents(new PingListener(), this);
		
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		//Registrar eventos
		Bukkit.getPluginManager().registerEvents(this, this);
		
		//Comandos
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("number").setExecutor(new NumberCommand());
		getCommand("consoleonly").setExecutor(new NumberCommand());
		getCommand("serverRules").setExecutor(new ServerCommand(this));
		getCommand("vanish").setExecutor(new VanishCommand(this));
		getCommand("menu").setExecutor(new MenuCommand(this));
		getCommand("myskull").setExecutor(new MySkullCommand());
		getCommand("anyskull").setExecutor(new AnySkullCommand());
		
		//spawnar algo
		spawnStand(new Location(Bukkit.getWorld("world"), 8, 4, 3));
		
		//boss bar
		Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
		
		bossbar = Bukkit.createBossBar(ChatColor.RED + "MazeRunner Disponivel!", 
				BarColor.GREEN, 
				BarStyle.SOLID);
		
		//bossbar.setProgress(0.5);
		
		//Hologramas
		Bukkit.getPluginManager().registerEvents(new HologramListener(this), this);
		
		//Toggling
		Bukkit.getPluginManager().registerEvents(new ToggleListener(), this);
		
		//Map Modification
		Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
		
		//Resource packs
		//Bukkit.getPluginManager().registerEvents(new ResourcePacks(), this);
		
		//Sound Events
		Bukkit.getPluginManager().registerEvents(new SoundEvents(), this);
		
		//GUI
		Bukkit.getPluginManager().registerEvents(new MenuListener(this), this);
		
		//Signs
		Bukkit.getPluginManager().registerEvents(new SignListener(), this);
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("TEST PLUGIN DISABLED!");
	}
	
	//Hologramas
	public void spawnHologram(Player player) {
		String rawName = "Este é um teste|para ver se funciona!";
		String[] name = rawName.split("|");
		
		for(int i = 0; i < name.length; i++) {
			
		}
		
		ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 0.5, 0), EntityType.ARMOR_STAND);
		stand.setVisible(false);
		stand.setGravity(false);
		stand.setInvulnerable(true);
		
		stand.setCustomNameVisible(true);
		stand.setCustomName(ChatColor.GRAY + "Criado por " + ChatColor.GREEN + player.getName());
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(!p.hasPermission("firstPlugin.allowmove")) {
			//e.setCancelled(true);
		}
		
	}
	
	/*ELYTRA UI*/
	public void applyElytraUI(Player player) {
		
		//BEGINNING
		
		Inventory gui = Bukkit.createInventory(null, 45, ChatColor.GREEN + "Elytra menu!");
		
		//LORES
		
		List<String> enableLore = new ArrayList<>();
		enableLore.add(ChatColor.GRAY + "Clique em mim para");
		enableLore.add(ChatColor.GRAY + "ativar o que acontece");
		
		List<String> disableLore = new ArrayList<>();
		disableLore.add(ChatColor.GRAY + "Clique em mim para");
		disableLore.add(ChatColor.GRAY + "desativar o que acontece");
		
		List<String> launchLore = new ArrayList<>();
		launchLore.add(ChatColor.GRAY + "Clique para ser lançado");
		launchLore.add(ChatColor.GRAY + "para cima 200 blocos! :D");
		//ITEMSTACKS
		
		ItemStack toggle;
		ItemMeta toggleMeta;
		if(player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType().equals(Material.ELYTRA)) {
			toggle = new ItemStack(Material.REDSTONE_BLOCK);
			
			toggleMeta = toggle.getItemMeta();
			toggleMeta.setDisplayName(ChatColor.RED + "Disabled Elytra!");
			toggleMeta.setLore(disableLore);
		} else {
			toggle = new ItemStack(Material.EMERALD_BLOCK);
			
			toggleMeta = toggle.getItemMeta();
			toggleMeta.setDisplayName(ChatColor.RED + "Enable Elytra!");
			toggleMeta.setLore(enableLore);
		}

		toggle.setItemMeta(toggleMeta);
		
		ItemStack launch = new ItemStack(Material.WEB);
		ItemMeta launchMeta = launch.getItemMeta();
		launchMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Launch into to the air!");
		launchMeta.setLore(launchLore);
		launch.setItemMeta(launchMeta);
		
		//ITEM SETTING
		
		gui.setItem(34, toggle);
		gui.setItem(4, launch);
		
		//FINAL
		player.openInventory(gui);
	}
	
	//Projeteis
	@EventHandler
	public void onLaunch(ProjectileLaunchEvent e) {
		
		e.getEntity().getShooter();
		
	}
	
	@EventHandler
	public void onHit(ProjectileHitEvent e) {
		
		e.getEntity().getShooter();
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_HOE)){
				Egg egg = e.getPlayer().launchProjectile(Egg.class, e.getPlayer().getLocation().getDirection());
			}
		}
		
	}
	
	//Armor stand things
	private void spawnStand(Location location) {
		
		ArmorStand stand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		
		stand.setSmall(false);
		stand.setBasePlate(false);
		stand.setArms(true);
		
		stand.setGravity(true);
		stand.setInvulnerable(true);
		
		stand.setCustomName("Alo");
		stand.setCustomNameVisible(true);
		stand.setVisible(true);
		
		//stand.setHealth(arg0);
		stand.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		//stand.setLeggings(arg0);
		//stand.setBoots(arg0);
		stand.setItemInHand(new ItemStack(Material.APPLE));
		
		//52, 125, 81
		stand.setHeadPose(new EulerAngle(Math.toRadians(52), Math.toRadians(125), Math.toRadians(81)));
		//stand.setLeftArmPose(arg0);
		//stand.setRightArmPose(arg0);
		//stand.setLeftLegPose(arg0);
		//stand.setRightLegPose(arg0);
		//stand.setBodyPose(arg0);
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
