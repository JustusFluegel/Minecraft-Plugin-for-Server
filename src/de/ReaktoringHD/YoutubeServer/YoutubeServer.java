package de.ReaktoringHD.YoutubeServer;


import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.ReaktoringHD.YoutubeServer.Scoreboard.Money;
import de.ReaktoringHD.YoutubeServer.commands.ChatClear;
import de.ReaktoringHD.YoutubeServer.commands.ChatClearme;
import de.ReaktoringHD.YoutubeServer.commands.Kill;
import de.ReaktoringHD.YoutubeServer.commands.Setspawn;
import de.ReaktoringHD.YoutubeServer.commands.Spawn;
import de.ReaktoringHD.YoutubeServer.events.BlockBreakEvent;
import de.ReaktoringHD.YoutubeServer.events.ReloadMessage;
import de.ReaktoringHD.YoutubeServer.navigation.GameNavigator;
import de.ReaktoringHD.YoutubeServer.navigation.ItemClickEvent;
import de.ReaktoringHD.YoutubeServer.navigation.STP;
import de.ReaktoringHD.YoutubeServer.player.JoinEvent;
import de.ReaktoringHD.YoutubeServer.royale.Blue;
import de.ReaktoringHD.YoutubeServer.royale.BlueCommands;

public class YoutubeServer extends JavaPlugin{

	public static Inventory inv = null;
	public static Inventory telinv = null;
	
	public static String name = "Hypergod";
	public static String ys = "§7[§b"+ name +"§7] §0";
	public static String kys = "["+ name +"] ";
	public static String noperm = ys + "§4Du hast leider keine Rechte!";
	
	public static int money = 0;
	
	public static String configPath = "plugins"+ File.separator + "Youtubeserver" + File.separator + "config";
	public static File playerconfig = new File(configPath + File.separator + "playerconfig");
	public static File config = new File(configPath);
	public static File spawnconfig = new File(configPath + File.separator + "spawnconfig.yml");
	
	public void onEnable(){
		
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new ReloadMessage(), this);
		pm.registerEvents(new JoinEvent(), this);
		pm.registerEvents(new Blue(), this);
		pm.registerEvents(new GameNavigator(), this);
		pm.registerEvents(new ItemClickEvent(), this);
		pm.registerEvents(new BlockBreakEvent(), this);
		
		getCommand("cc").setExecutor(new ChatClearme());
		getCommand("cca").setExecutor(new ChatClear());
		getCommand("kill").setExecutor(new Kill());
		getCommand("chatclear").setExecutor(new ChatClearme());
		getCommand("chatclearall").setExecutor(new ChatClear());
		getCommand("setspawn").setExecutor(new Setspawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("l").setExecutor(new Spawn());
		getCommand("lobby").setExecutor(new Spawn());
		getCommand("hub").setExecutor(new Spawn());
		getCommand("money").setExecutor(new Money());
		getCommand("blau").setExecutor(new BlueCommands());
		getCommand("stp").setExecutor(new STP());
		
		System.out.println(kys + "Plugin Gestartet!");
		
	}
	
	public void onDisable(){
		System.out.println(kys + "Plugin stoppt! Bitte nicht abbrechen! Bye :D!");
	}
	
	public static void exists(File folder, File file){
		
		if(!file.exists()){
			
			if(!folder.exists()){
				
				folder.mkdir();
				
			}
			
			try {
				
				file.createNewFile();
				
			} 
			
			catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public static void writeLocation(Player p, String name){
		
		if(!YoutubeServer.config.exists()){
			
			YoutubeServer.config.mkdir();
			
		}
		
		if(!YoutubeServer.spawnconfig.exists()){
			
			try{
				
				YoutubeServer.spawnconfig.createNewFile();
				
			}
			
			catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(spawnconfig);
		
		Location loc = p.getLocation();
		
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		
		float pitch = loc.getPitch();
		float yaw = loc.getYaw();
		
		String worldname = loc.getWorld().getName();
		
		cfg.set(name + ".Spawn.x", x);
		cfg.set(name + ".Spawn.y", y);
		cfg.set(name + ".Spawn.z", z);
		
		cfg.set(name + ".Spawn.pitch", pitch);
		cfg.set(name + ".Spawn.yaw", yaw);
		
		cfg.set(name + ".Spawn.worldname", worldname);
		
		try{
					
		cfg.save(spawnconfig);
		
		}
		catch(IOException e){
			
			e.printStackTrace();
			
		}
		
		
	}
	
	public static boolean loadLocation(Player p,String location ){
		
		if(YoutubeServer.spawnconfig.exists()){
		
			YamlConfiguration scfg = YamlConfiguration.loadConfiguration(YoutubeServer.spawnconfig);
			
			Location loc = p.getLocation();
		
			loc.setX(scfg.getDouble(location +".Spawn.x"));
			loc.setY(scfg.getDouble(location +".Spawn.y"));
			loc.setZ(scfg.getDouble(location +".Spawn.z"));
			
			loc.setPitch((float) scfg.getDouble(location +".Spawn.pitch"));
			loc.setYaw((float) scfg.getDouble(location +".Spawn.yaw"));
			
			loc.setWorld(Bukkit.getWorld(scfg.getString(location +".Spawn.worldname")));
			
			p.teleport(loc);
			
			return true;
		
		}
		
		return false;
	
	}

		
	
}
