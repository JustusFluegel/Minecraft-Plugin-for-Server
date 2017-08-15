package de.ReaktoringHD.YoutubeServer.Scoreboard;


import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class Money implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;																								//Bekomme den Spieler, der das Kommando "geschickt" hat
		
		File configurationPath = new File(YoutubeServer.configPath + "//playerconfig//");										//Lege eine Variable mit dem Odnerpfad von den Spielerconfigs an
		File configurationFile = new File(YoutubeServer.configPath + "//playerconfig//" + p.getUniqueId() + ".yml");			//Lege eine Variable mit dem Dateipfad an
		 
		 
		 YoutubeServer.exists(configurationPath , configurationFile);															//überprüfe, ob alle erforderlichen Dateien existieren
		
		 if(p.hasPermission("youtubeserver.editmoney")){																		//checke die Berechtigungen
			 
			 if(args.length == 3){																								//überprüfen, ob passend viele Argumente angegeben wurden
				 
				  try{
					 
					 int anzahlgeldarg = 0 ;
					 
					 final Player a = p.getServer().getPlayer(args[2]);
				 
				
				 
					 try{
					 
						 anzahlgeldarg = Integer.parseInt(args[1]);
						 
					 }
				 
					 catch(NumberFormatException e){
					 
						 p.sendMessage(YoutubeServer.ys + "§4 " + args[1] + " ist keine Anzahl!");
						 
						 return true;
					 
					 }
					 
					 if(args[0].equalsIgnoreCase("set")){																			//überprüfen, ob das Geld gesetzt werden soll
					 
						 moneyedit(anzahlgeldarg, "set" , a);
						 Sidebar.updateScoreboard(a);
					 
					 }
				 
					 else if(args[0].equalsIgnoreCase("add")){																		//überprüfen, ob das Geld addiert werden soll
					 
						 moneyedit(anzahlgeldarg, "add" , a);
						 Sidebar.updateScoreboard(a);
					 
					 }
				 
					 else if(args[0].equalsIgnoreCase("delete")){																	//überprüfen, pb das Geld subtrahiert werden soll
					
						 moneyedit(anzahlgeldarg, "delete" , a); 
						 Sidebar.updateScoreboard(a);
					 
					 }
				 
				 }
				 
				 catch(NullPointerException e){
					 
					 p.sendMessage( YoutubeServer.ys + "§4 Der Spieler " + args[2] + "ist nicht Online!");
					 
				 }
			 }
			 
			 else if(args.length == 2){																							//überprüfen, ob passend viele Argumente angegeben wurden
				
				 int anzahlgeldarg = 0;
				 
				 try{
					 
					 anzahlgeldarg = Integer.parseInt(args[1]);
					 
				 }
			 
				 catch(NumberFormatException e){
				 
					 p.sendMessage(YoutubeServer.ys + "§4 " + args[1] + " ist keine Anzahl!");
					 
					 return true;
				 
				 }
				 
				 if(args[0].equalsIgnoreCase("set")){																			//überprüfen, ob das Geld gesetzt werden soll
					 
					moneyedit(anzahlgeldarg, "set", p); 
					 
				 }
				 
				 else if(args[0].equalsIgnoreCase("add")){																		//überprüfen, ob das Geld addiert werden soll
					 
					 moneyedit(anzahlgeldarg, "add", p);
					 
				 }
				 
				 else if(args[0].equalsIgnoreCase("delete")){																	//überprüfen, pb das Geld subtrahiert werden soll
					 
					 moneyedit(anzahlgeldarg, "delete", p);
					 
				 }
				 
				 
			 }
			 
			 else{
			
				 p.sendMessage(YoutubeServer.ys + "§r Bitte benutze §7 /money <add|delete|set> <anzahl> [Player]");				//ansonsten Fehlernachricht schicken
				 
			 }
			 
		 }
		 
		 else{p.sendMessage(YoutubeServer.noperm);}																				//sende einen Spieler ohne die Erforderlichen Berechtigungen eine Fehlernachricht
		 
		 Sidebar.updateScoreboard(p);
		 
		return true;																											//Beende das Void
		
	}
	
	public static void moneyedit(int anzahl, String art , Player p){
		
		File configurationPath = new File(YoutubeServer.configPath + "//playerconfig//");										//Lege eine Variable mit dem Odnerpfad von den Spielerconfigs an
		File configurationFile = new File(YoutubeServer.configPath + "//playerconfig//" + p.getUniqueId() + ".yml");			//Lege eine Variable mit dem Dateipfad an
		YoutubeServer.exists(configurationPath , configurationFile);															//überprüfe, ob alle erforderlichen Dateien existieren
		
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(configurationFile);											// Öffne die YamlConfiguration
		
		int Money = cfg.getInt("Scoreboard.money");
		
		if(art.equalsIgnoreCase("set")){
			
			cfg.set("Scoreboard.money", anzahl);
			
		}
		
		if(art.equalsIgnoreCase("add")){
			
			cfg.set("Scoreboard.money", Money + anzahl);
			
		}
		
		if(art.equalsIgnoreCase("delete")){
			
			cfg.set("Scoreboard.money", Money - anzahl);
			
		}
		
		try {
			
			cfg.save(configurationFile);
			
		} 
		
		catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
}
