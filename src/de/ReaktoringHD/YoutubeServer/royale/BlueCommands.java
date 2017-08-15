package de.ReaktoringHD.YoutubeServer.royale;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;
import de.ReaktoringHD.YoutubeServer.commands.Spawn;

public class BlueCommands implements CommandExecutor {

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(args.length == 1 && p.hasPermission("youtubeserver.royale")){
			
			if(args[0].equalsIgnoreCase("spawn")){
				
				if(!(sender instanceof ConsoleCommandSender)){					
					
					File config = new File("plugins//Youtubeserver//config//royale//config.yml");
					
					config(config);
						
					YamlConfiguration scfg = YamlConfiguration.loadConfiguration(config);
						
					Location loc = p.getLocation();
						
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();
						
					float pitch = loc.getPitch();
					float yaw = loc.getYaw();
					
					String worldname = loc.getWorld().getName();
						
					scfg.set("Blue.Spawnposition.Spawn.x", x);
					scfg.set("Blue.Spawnposition.Spawn.y", y);
					scfg.set("Blue.Spawnposition.Spawn.z", z);
					
					scfg.set("Blue.Spawnposition.Spawn.pitch", pitch);
					scfg.set("Blue.Spawnposition.Spawn.yaw", yaw);
						
					scfg.set("Blue.Spawnposition.Spawn.worldname", worldname);
						
					try{
									
					scfg.save(config);
						
					}
					catch(IOException e){
						
						e.printStackTrace();
							
					}
						
					p.sendMessage(YoutubeServer.ys + "§8Die Blue.Spawnposition vom Blauen \"RoyaleTeam\" wurde erfolgreich gespeichert!");
						
					
					
				}
				
			}
			
			if(args[0].equalsIgnoreCase("tp")){
				
				File config = new File("plugins//Youtubeserver//config//royale//config.yml");
				
				config(config);
				
				YamlConfiguration scfg = YamlConfiguration.loadConfiguration(config);
				
				scfg.set("Blue.name", p.getUniqueId().toString() ); 
				
				try {
					
					scfg.save(config);
					
				} 
				
				catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
				Location loc = p.getLocation();
				
				loc.setX(scfg.getDouble("Blue.Spawnposition.Spawn.x"));
				loc.setY(scfg.getDouble("Blue.Spawnposition.Spawn.y"));
				loc.setZ(scfg.getDouble("Blue.Spawnposition.Spawn.z"));
				
				loc.setPitch((float) scfg.getDouble("Blue.Spawnposition.Spawn.pitch"));
				loc.setYaw((float) scfg.getDouble("Blue.Spawnposition.Spawn.yaw"));
				
				loc.setWorld(Bukkit.getWorld(scfg.getString("Blue.Spawnposition.Spawn.worldname")));
				
				p.teleport(loc);
				
			}
			
			if(args[0].equalsIgnoreCase("exit")){
				
				File config = new File("plugins//Youtubeserver//config//royale//config.yml");
				
				config(config);
				
				YamlConfiguration scfg = YamlConfiguration.loadConfiguration(config);
				
				scfg.set("Blue.name", "" ); 
				
				try {
					
					scfg.save(config);
					
				} 
				
				catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
				Spawn.spawn(p);
				
			}
			
		}
		
		return true;
		
	}

	public static void config(File config){
	
		if(!config.exists()){
		
			if(!(new File("plugins//Youtubeserver//config//royale")).exists()){
			
				if(!(new File("plugins//Youtubeserver//config")).exists()){
					
					if(!(new File("plugins//Youtubeserver")).exists()){
					
						(new File("plugins//Youtubeserver")).mkdir();
					
					}
					
					(new File("plugins//Youtubeserver//config")).mkdir();
				
				}
			
				(new File("plugins//Youtubeserver//config//royale")).mkdir();
			
			}
		
			try {
			
				config.createNewFile();
			
			} 
		
			catch (IOException e1) {
			
				e1.printStackTrace();
			
			}
		
			YamlConfiguration scfg = YamlConfiguration.loadConfiguration(config);
		
			scfg.set("Blue.name", "");
		
			try {
			
				scfg.save(config);
			
			} 
		
			catch (IOException e1) {
			
				e1.printStackTrace();
			
			}
		
		}

	}

	
}
