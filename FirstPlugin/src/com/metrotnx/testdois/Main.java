package com.metrotnx.testdois;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private int counter;
	
	@Override
	public void onEnable() {
		System.out.println("Plugin teste dois ligado!");
		
		Bukkit.getScheduler().runTaskLater(this, new Runnable() {
			public void run() {
				System.out.println("Plugin está funcionando por 5 segundos!");
			}
		}, 100L);
		
		counter = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				System.out.println("10 segundos!");
			}
		}, 200L, 200L);
		
		//Bukkit.getScheduler().cancelAllTasks();
		//Bukkit.getScheduler().cancelTask(counter);
	}
	
}
