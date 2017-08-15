package de.ReaktoringHD.YoutubeServer.commands;

import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class Setspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof ConsoleCommandSender)){
			
			Player p = (Player) sender;
			
			if(!(p.hasPermission("youtubeserver.setspawn"))){
				
				p.sendMessage(YoutubeServer.noperm);
				
			}
			
			else{
						
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
				
				YamlConfiguration scfg = YamlConfiguration.loadConfiguration(YoutubeServer.spawnconfig);
				
				Location loc = p.getLocation();
				
				double x = loc.getX();
				double y = loc.getY();
				double z = loc.getZ();
				
				float pitch = loc.getPitch();
				float yaw = loc.getYaw();
				
				String worldname = loc.getWorld().getName();
				
				scfg.set("Spawnposition.Spawn.x", x);
				scfg.set("Spawnposition.Spawn.y", y);
				scfg.set("Spawnposition.Spawn.z", z);
				
				scfg.set("Spawnposition.Spawn.pitch", pitch);
				scfg.set("Spawnposition.Spawn.yaw", yaw);
				
				scfg.set("Spawnposition.Spawn.worldname", worldname);
				
				try{
							
				scfg.save(YoutubeServer.spawnconfig);
				
				}
				catch(IOException e){
					
					e.printStackTrace();
					
				}
				
				p.sendMessage(YoutubeServer.ys + "§8Die Spawnposition vom Hauptspawn wurde erfolgreich gespeichert!");
				
			}
			
		}
		
		return true;
		
	}

}
