package com.metrotnx.privateMessage;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	/* COMMANDS
	 * - message <player> <message>
	 * - reply <message>
	 * */
	
	private MessageManager manager;
	
	@Override
	public void onEnable() {
		System.out.println("Private Message loaded!");
		
		getCommand("message").setExecutor(new MessageCommand(this));
		getCommand("reply").setExecutor(new ReplyCommand(this));
		
		manager = new MessageManager(this);
		
	}

	public MessageManager getMessageManager() { return manager; }
	
}
