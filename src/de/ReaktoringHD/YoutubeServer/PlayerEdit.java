package de.ReaktoringHD.YoutubeServer;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerEdit {

	public static void editPlayerconfig( Player  player , String ort, Object obj){
	
		File configurationPath = new File(YoutubeServer.configPath + File.separator + "playerconfig" + File.separator);										
		File configurationFile = new File(YoutubeServer.configPath + File.separator + "playerconfig" + File.separator + player.getUniqueId() + ".yml");			
		 
		YoutubeServer.exists(configurationPath , configurationFile);
		 
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(configurationFile);
		
		cfg.set(ort, obj);
		
		try {
			
			cfg.save(configurationFile);
			
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static String readPlayerconfig( Player  player , String ort){
		
		File configurationPath = new File(YoutubeServer.configPath + File.separator + "playerconfig" + File.separator);										
		File configurationFile = new File(YoutubeServer.configPath + File.separator + "playerconfig" + File.separator + player.getUniqueId() + ".yml");			
		 
		YoutubeServer.exists(configurationPath , configurationFile);
		 
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(configurationFile);
		 
		return cfg.getString(ort);
		
	}
	
}
