package de.ReaktoringHD.YoutubeServer.events;


import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Deadevent implements Listener{

	public static void onDead(PlayerDeathEvent e){
		
		e.setKeepInventory(true);
		Player p = e.getEntity().getPlayer();
		
		p.setHealth(10000000.0);
	}
	
	
}
