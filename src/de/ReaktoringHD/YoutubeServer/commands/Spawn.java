package de.ReaktoringHD.YoutubeServer.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class Spawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof ConsoleCommandSender)){
		
			Player p = (Player) sender;
			
			spawn(p);
			
			p.sendMessage(YoutubeServer.ys + "§8Du wurdest zum Spawn Teleportiert!");
		}
		
		return true;
		
	}
	
	public static void spawn(Player p){
		
			if(YoutubeServer.spawnconfig.exists()){
			
				YamlConfiguration scfg = YamlConfiguration.loadConfiguration(YoutubeServer.spawnconfig);
				
				Location loc = p.getLocation();
			
				loc.setX(scfg.getDouble("Spawnposition.Spawn.x"));
				loc.setY(scfg.getDouble("Spawnposition.Spawn.y"));
				loc.setZ(scfg.getDouble("Spawnposition.Spawn.z"));
				
				loc.setPitch((float) scfg.getDouble("Spawnposition.Spawn.pitch"));
				loc.setYaw((float) scfg.getDouble("Spawnposition.Spawn.yaw"));
				
				loc.setWorld(Bukkit.getWorld(scfg.getString("Spawnposition.Spawn.worldname")));
				
				p.teleport(loc);			
			
			}
			
			else{
				
				p.sendMessage(YoutubeServer.ys +"§4 Kein Spafnpunkt Gesetzt oder Config unter \"plugins/Youtubeserver/config\" beschädigt!");
				
			}
		
	}

}
