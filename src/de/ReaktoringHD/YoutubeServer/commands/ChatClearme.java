package de.ReaktoringHD.YoutubeServer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class ChatClearme implements CommandExecutor {
 
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(sender instanceof ConsoleCommandSender){
				
			for(int i = 0; i < 200; i++){
				
				System.out.println("  ");
				
			}
				
		}
		
		else{
			
			Player p = (Player) sender;
			
			if(args.length == 1){
				
				if(p.hasPermission("youtubeserver.cco")){
					
					try{
					
						Player e = p.getServer().getPlayer(args[0]);
					
						for(int i = 0; i < 200; i++){
							
							e.sendMessage(" ");
							
						}
					
						e.sendMessage(YoutubeServer.ys +"§8Dein Chat wurde von §d"+ p.getName() +"§8 geleert!");
						p.sendMessage(YoutubeServer.ys +"§8Du hast den Chat von §d"+ e.getName() +"§8 erfolgreich geleert!");
					
					}
				
					catch(NullPointerException e){
						p.sendMessage(YoutubeServer.ys + "§4Spieler Nicht Online!");
					}
			
				}
				
			}
			
			else if(args.length == 0){
				
				for(int i = 0; i < 200; i++){
					p.sendMessage(" ");
				}
				
				p.sendMessage(YoutubeServer.ys +"§8Dein Chat wurde geleert.");
				
			}
		
			else{
			
				p.sendMessage(YoutubeServer.ys + "§4Ein Fehler ist aufgetreten!");
			
			}
			
		}
			
		return true;
	}
	
}
