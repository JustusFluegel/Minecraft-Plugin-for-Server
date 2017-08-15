package de.ReaktoringHD.YoutubeServer.royale;

import java.io.File;
import java.io.IOException;


import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Blue implements Listener{

	
	@EventHandler
	public static void onMoveBlue(PlayerMoveEvent e){
		
		File config = new File("plugins//Youtubeserver//config//royale//config.yml");
		
		config(config);
		
		YamlConfiguration scfg = YamlConfiguration.loadConfiguration(config);		
		
		Player p = e.getPlayer();
		
		if(p.getLocation().getWorld().getName() ==  "Royal Arena"){
			
			if(p.getUniqueId().toString() == scfg.getString("Blue.name")){
				
				e.setCancelled(true);
				
			}
			
		}
		
	}
	
	@EventHandler	
	public static void onBreakBlue(BlockBreakEvent e){
		
		File config = new File("plugins//Youtubeserver//config//royale//config.yml");
		
		config(config);
		
		YamlConfiguration scfg = YamlConfiguration.loadConfiguration(config);		
		
		Player p = e.getPlayer();
		
		if(p.getLocation().getWorld().getName() ==  "Royal Arena"){
			
			if(p.getUniqueId().toString() == scfg.getString("Blue.name")){
				
				e.setCancelled(true);
				
			}
			
		}
		
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
