package de.ReaktoringHD.YoutubeServer.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class ReloadMessage implements Listener {
	
	@EventHandler
	public void onReload(PlayerCommandPreprocessEvent e){
		
		Player p = e.getPlayer();
		String cmd = e.getMessage();
		
		if(cmd.equalsIgnoreCase("/rl") || cmd.equalsIgnoreCase("/reload")){
		
			e.setCancelled(true);
			
			if(p.hasPermission("youtubeserver.reload")){
			
				Bukkit.broadcastMessage(YoutubeServer.ys + "§8Die Serverdaten werden neu geladen!");
				Bukkit.reload();
				Bukkit.broadcastMessage(YoutubeServer.ys + "§8Das laden der Serverdaten wurde abgeschlossen.");
			
				return;
			}
		
			else{
			
				p.sendMessage(YoutubeServer.noperm);
			
				return;
			
			}
			
		}
		
	}
	
}
