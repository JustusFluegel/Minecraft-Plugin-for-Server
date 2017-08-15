package de.ReaktoringHD.YoutubeServer.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class destroyEvent implements Listener {
	
	@EventHandler
	public void onDestroy(BlockBreakEvent e){
		
		if(!e.getPlayer().hasPermission("youtubeserver.build")){
			
			e.setCancelled(true);
			
		}
		
	}

}
