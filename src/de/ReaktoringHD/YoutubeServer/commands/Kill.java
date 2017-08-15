package de.ReaktoringHD.YoutubeServer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class Kill implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
			if (sender instanceof ConsoleCommandSender) {
				
				System.out.println(YoutubeServer.kys + "Du kannst die Konsole nicht töten!");
				
				return true;
				
			}
			
			else{
				
				Player p = (Player) sender;
			
				if(args.length == 0){
				
					p.setHealth(0.0);
					p.sendMessage(YoutubeServer.ys + "§8Du hast dich getötet! §4Selbst schuld!");
				
					return true;
				}
			
				else if(args.length == 1 && p.hasPermission("youtubeserver.kill")){
				
					try{
					
						Player a = p.getServer().getPlayer(args[0]);
					
						if((a.hasPermission("youtubeserver.kill") && !(p.hasPermission("youtubeserver.op"))) || a.hasPermission("youtubeserver.op")){
							
							if(a.hasPermission("youtubeserver.premium")){
								
								p.sendMessage(YoutubeServer.ys + "§4Du kanst den Premium §b" + a.getName() + "§4 nicht töten!");
							
							}
							
							if(a.hasPermission("youtubeserver.Ultra")){
								
								p.sendMessage(YoutubeServer.ys + "§4Du kanst den Ultra §b" + a.getName() + "§4 nicht töten!");
							
							}
							
							if(a.hasPermission("youtubeserver.op")){
								
								p.sendMessage(YoutubeServer.ys + "§4Du kanst den Op §b" + a.getName() + "§4 nicht töten!");
								
							}
						
							return true;
						}
					
						else{
						
							a.setHealth(0.0);
							a.sendMessage(YoutubeServer.ys + "§8Du wurdest von §b"+ p.getName() + " §cgetötet!");
							p.sendMessage(YoutubeServer.ys + "§2Du hast §b"+ a.getName() + " §2erfolgreich getötet!");
						
						}
					
					}
				
					catch(NullPointerException e){
					
						p.sendMessage(YoutubeServer.ys + "§4Fehler! NullPointerException / Spieler nicht online: §b"+ args[0]);
					
					}
				
					return true;
				
				}
			
				else if(args.length == 1){
				
					p.sendMessage(YoutubeServer.ys + "§4Du hast leider keine Rechte! Du kannst aber §7/kill §4benutzen, um dich selber zu töten!");
				
					return true;
				}
			
				else if(args.length != 0 && args.length != 1 && p.hasPermission("youtubeserver.kill")){
				
					p.sendMessage(YoutubeServer.ys + "§4Benutze bitte §7/kill [Spieler] §4!");
				
					return true;
				
				}
			
				else if(args.length != 0 && args.length != 1 && p.hasPermission("youtubeserver.kill") == false){
				
					p.sendMessage(YoutubeServer.ys + "§4Benutze bitte §7/kill §4um dich zu töten!");
				
					return true;
				
				}
			
				else{
					p.sendMessage(YoutubeServer.ys + "§4Sorry! Leider hat da etwas nicht geklappt!");
				
					return true;
				
				}
			}
					
	}
	
}
