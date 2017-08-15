package de.ReaktoringHD.YoutubeServer.navigation;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class ItemClickEvent implements Listener {
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("§3Games") || e.getInventory().getName().equalsIgnoreCase("§3Teleport Punkte")){
			
			e.setCancelled(true);
			
			if(e.getInventory().getName().equalsIgnoreCase("§3Games")){
				
				if(e.getCurrentItem().getType() == Material.BED){
				
					p.sendMessage(YoutubeServer.ys + "§8Das ist Bedwars");		
					
					p.closeInventory();
				
				
				}
				
			}
			
			if(e.getInventory().getName().equalsIgnoreCase("§3Teleport Punkte")){
				
				e.setCancelled(true);
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Shop")){
					
					YoutubeServer.loadLocation(p, "shop");
					
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Games")){
					
					YoutubeServer.loadLocation(p, "games");
					
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Owner & Admins")){
					
					YoutubeServer.loadLocation(p, "owner");
					
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Ultra und Legend kaufen")){
					
					YoutubeServer.loadLocation(p, "legend");
					
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\"Free Fall\"-Tower")){
					
					YoutubeServer.loadLocation(p, "FreeFall");
					
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Jump'n Run mittel")){
					
					
					YoutubeServer.loadLocation(p, "Jumpmittel");
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Jump'n Run schwer")){
					
					YoutubeServer.loadLocation(p, "Jumpschwer");
					
				}
				
			}
			
		}
		
	}

}
