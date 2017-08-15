package de.ReaktoringHD.YoutubeServer.navigation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class STP implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(p.hasPermission("youtubeserver.setspawn") && args.length == 1){
				
			if(args[0].equalsIgnoreCase("shop")){
				
				YoutubeServer.writeLocation(p, "shop");
				
				p.sendMessage(YoutubeServer.ys + "§8Die spawnposition \"shop\" wurde gesetzt!");
				
			}
			
			else if(args[0].equalsIgnoreCase("games")){
				
				YoutubeServer.writeLocation(p, "games");
				
				p.sendMessage(YoutubeServer.ys + "§8Die spawnposition \"games\" wurde gesetzt!");
				
			}
			
			else if(args[0].equalsIgnoreCase("owner")){
				
				YoutubeServer.writeLocation(p, "owner");
				
				p.sendMessage(YoutubeServer.ys + "§8Die spawnposition \"owner\" wurde gesetzt!");
				
			}
			
			else if(args[0].equalsIgnoreCase("legend")){
				
				YoutubeServer.writeLocation(p, "legend");
				
				p.sendMessage(YoutubeServer.ys + "§8Die spawnposition \"legend\" wurde gesetzt!");
				
			}
			
			else if(args[0].equalsIgnoreCase("FreeFall")){
				
				YoutubeServer.writeLocation(p, "FreeFall");
				
				p.sendMessage(YoutubeServer.ys + "§8Die spawnposition \"FreeFall\" wurde gesetzt!");
				
			}

			else if(args[0].equalsIgnoreCase("Jumpmittel")){
	
				YoutubeServer.writeLocation(p, "Jumpmittel");
				
				p.sendMessage(YoutubeServer.ys + "§8Die spawnposition \"Jumpmittel\" wurde gesetzt!");
	
			}

			else if(args[0].equalsIgnoreCase("Jumpschwer")){
	
				YoutubeServer.writeLocation(p, "Jumpschwer");
				
				p.sendMessage(YoutubeServer.ys + "§8Die spawnposition \"Jumpschwer\" wurde gesetzt!");
	
			}
			
			else{
				
				p.sendMessage(YoutubeServer.ys + "§4 Es gibt nur diese Locations : §8shop§4 , §8games§4 , §8owner §4, §8legend §4, §8freefall §4, §8Jumpmittel§4 und §8Jumpschwer§4 !");
				
			}
			
			
			
		}
		
		else {
			
			p.sendMessage(YoutubeServer.ys + "§4Benutze bitte §7/stp <Warp:§8shop§4 , §8games§4 , §8owner §4, §8legend §4, §8freefall §4, §8Jumpmittel§4 und §8Jumpschwer§7> §4!");
			
		}
		
		return true;
		
	}

}
