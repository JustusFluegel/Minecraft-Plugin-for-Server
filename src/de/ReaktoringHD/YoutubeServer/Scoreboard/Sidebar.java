package de.ReaktoringHD.YoutubeServer.Scoreboard;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import de.ReaktoringHD.YoutubeServer.YoutubeServer;

public class Sidebar implements Listener{
	
	public static int hmu = 9;
	
	public static void updateScoreboard(Player p){
		
		YamlConfiguration scfg = YamlConfiguration.loadConfiguration(new File("plugins//Youtubeserver//config//playerconfig//"+ p.getUniqueId() + ".yml"));
		
		ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard board = sm.getNewScoreboard();
		Objective obj = board.registerNewObjective("sidebar", "dummy"); 
		
		obj.setDisplayName("§f§n§l" + YoutubeServer.name);
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		hmu = 9;
		
		newScLine(obj, " ");
		newScLine(obj, "§fGeld:");
		newScLine(obj, "§e" + scfg.getInt("Scoreboard.money"));
		newScLine(obj, "  ");
		newScLine(obj, "§fFreunde:");
		newScLine(obj, "§a0/? §7Online");
		newScLine(obj, "   ");
		newScLine(obj, "§fServer:");
		newScLine(obj, "hypergod.de");
		
		p.setScoreboard(board);
		
	}
	
	private static void newScLine(Objective obj, String sct){
		
		obj.getScore(sct).setScore(Sidebar.hmu);
		
		Sidebar.hmu--;
		
	}
	
}
