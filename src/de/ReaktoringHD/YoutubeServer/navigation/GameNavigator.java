package de.ReaktoringHD.YoutubeServer.navigation;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class GameNavigator implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lGames") && e.getMaterial().equals(Material.COMPASS)){
				
				e.setCancelled(true);
				
				YoutubeServer.inv = p.getServer().createInventory(null, 45 , "§3Games");
				
				ItemStack item = new  ItemStack(Material.BED);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("Bedwars");
				item.setItemMeta(meta);
				
				YoutubeServer.inv.setItem(13, item);
				
				p.openInventory(YoutubeServer.inv);
				
			}
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lTeleporter") && e.getMaterial().equals(Material.NETHER_STAR)){
				
				e.setCancelled(true);
				
				YoutubeServer.telinv = p.getServer().createInventory(null, 9 , "§3Teleport Punkte");
				
				ItemStack item = new  ItemStack(Material.GOLD_NUGGET);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("Shop");
				item.setItemMeta(meta);
				
				YoutubeServer.telinv.setItem(1, item);
				
				ItemStack item1 = new  ItemStack(Material.EMPTY_MAP);
				ItemMeta meta1 = item1.getItemMeta();
				meta1.setDisplayName("Games");
				item1.setItemMeta(meta1);
				
				YoutubeServer.telinv.setItem(2, item1);
				
				ItemStack item2 = new  ItemStack(Material.BEDROCK);
				ItemMeta meta2 = item2.getItemMeta();
				meta2.setDisplayName("Owner & Admins");
				item2.setItemMeta(meta2);
				
				YoutubeServer.telinv.setItem(3, item2);
				
				ItemStack item3 = new  ItemStack(Material.BANNER);
				ItemMeta meta3 = item3.getItemMeta();
				meta3.setDisplayName("Ultra und Legend kaufen");
				item3.setItemMeta(meta3);
				
				YoutubeServer.telinv.setItem(4, item3);
				
				ItemStack item4 = new  ItemStack(Material.SLIME_BLOCK);
				ItemMeta meta4 = item4.getItemMeta();
				meta4.setDisplayName("\"Free Fall\"-Tower");
				item4.setItemMeta(meta4);
				
				YoutubeServer.telinv.setItem(5, item4);
				
				ItemStack item5 = new  ItemStack(Material.GOLD_BOOTS);
				ItemMeta meta5 = item5.getItemMeta();
				meta5.setDisplayName("Jump'n Run mittel");
				item5.setItemMeta(meta5);
				
				YoutubeServer.telinv.setItem(6, item5);
				
				ItemStack item6 = new  ItemStack(Material.DIAMOND_BOOTS);
				ItemMeta meta6 = item6.getItemMeta();
				meta6.setDisplayName("Jump'n Run schwer");
				item6.setItemMeta(meta6);
				
				YoutubeServer.telinv.setItem(7, item6);
				
				p.openInventory(YoutubeServer.telinv);
				
			}
					
		}
		
		if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lGames") && e.getMaterial().equals(Material.COMPASS)){
				
				e.setCancelled(true);
				
			}
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lTeleporter") && e.getMaterial().equals(Material.NETHER_STAR)){
				
				e.setCancelled(true);
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lGames")){
			e.setCancelled(true);			
		}
		
	}
	
	@EventHandler
	public void onInteract(InventoryClickEvent e){
		
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lTeleporter") || e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lGames")){
			
			e.setCancelled(true);
			
		}
		
	}
	
}
