package de.ReaktoringHD.YoutubeServer.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;;
public class BlockBreakEvent implements Listener{
	
	@EventHandler
	public void onBreak(org.bukkit.event.block.BlockBreakEvent e){
		
		Player p = (Player) e.getPlayer();
		
		if(!p.hasPermission("youtubeserver.build")){
			
			e.setCancelled(true);
			
		}
		
	}

}
