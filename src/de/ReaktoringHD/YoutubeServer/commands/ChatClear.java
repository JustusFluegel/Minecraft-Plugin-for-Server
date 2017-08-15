package de.ReaktoringHD.YoutubeServer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class ChatClear implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof ConsoleCommandSender){
				
			System.out.println(YoutubeServer.kys + "Konsolen können nicht geleert werden!");
				
			return true;
				
		}
		else{
		
		Player p = (Player) sender;
			
			if(p.hasPermission("youtubeserver.cca") == false){
				
				p.sendMessage(YoutubeServer.noperm);
			
				return true;
			
			}
			
			else if(p.hasPermission("youtubeserver.cca")){
				
				for(int i = 0; i < 200; i++){
					Bukkit.broadcastMessage(" ");
				}
				
				Bukkit.broadcastMessage(YoutubeServer.ys +"§8Der Chat wurde vom Admin/Owner §d" + p.getName() + " §8geleert.");
				
			}
		
		}
			
		
			
		return true;
	}
	
	
}

