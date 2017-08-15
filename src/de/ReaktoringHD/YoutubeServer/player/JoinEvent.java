package de.ReaktoringHD.YoutubeServer.player;

import java.io.File;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;
import de.ReaktoringHD.YoutubeServer.Scoreboard.Sidebar;
import de.ReaktoringHD.YoutubeServer.commands.Spawn;

public class JoinEvent implements Listener{
	
	int sched;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		Player p = e.getPlayer();	
		File configurationPath = new File(YoutubeServer.configPath + "//playerconfig//");										//Lege eine Variable mit dem Odnerpfad von den Spielerconfigs an
		File configurationFile = new File(YoutubeServer.configPath + "//playerconfig//" + p.getUniqueId() + ".yml");			//Lege eine Variable mit dem Dateipfad an
		
		Spawn.spawn(p);
		
		YoutubeServer.exists(configurationPath, configurationFile);
		
		Sidebar.updateScoreboard(p);		

		e.setJoinMessage("  ");
		
		ItemStack item = new ItemStack(Material.COMPASS);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§5§lGames");
		item.setItemMeta(meta);
		
		ItemStack teleporter = new ItemStack(Material.NETHER_STAR);
		ItemMeta teleportermeta = teleporter.getItemMeta();
		teleportermeta.setDisplayName("§5§lTeleporter");
		teleporter.setItemMeta(teleportermeta);
		
		
		
		if(!p.isOp()){
			
			p.getInventory().clear();
			p.getInventory().setItem(0, item);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			p.getInventory().setItem(0, item);
			p.getInventory().setItem(7, teleporter);
		}
	
		else{
			
			p.getInventory().setItem(0, item);
			p.getInventory().setItem(7, teleporter);
			p.setGameMode(GameMode.CREATIVE);
			
		}
			
		Spawn.spawn(p);
		
	}
	
}
