/*
 * Main.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 | 2014 - 2015
 * Submitted to: Umbaska
 * 
*/

package uk.nfell2009.umbaska;

import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.palmergames.bukkit.towny.object.Town;

import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.Skript;

/*
 *  Importing local packages
 */
import uk.nfell2009.umbaska.PlotMe.*;
import uk.nfell2009.umbaska.Spawner.*;
import uk.nfell2009.umbaska.Towny.*;

import uk.nfell2009.umbaska.Bungee.*;
import uk.nfell2009.umbaska.Misc.*;


public class Main extends JavaPlugin implements Listener {

	
	 @Override
	    public void onEnable() {
		 
		 final PluginManager pluginManager = getServer().getPluginManager();
		 pluginManager.registerEvents(this, this);
		 
		 loadConfiguration();
		 
		 Plugin pl = getServer().getPluginManager().getPlugin("PlotMe");
		 
		 if (pl != null) {
		 
		 /*
		  *  PlotMe - Effects
		  */
		 
		 Skript.registerEffect(EffPlotTeleport.class, new String[] { "teleport %player% to %string% in %world%" });
		 Skript.registerEffect(EffClearPlot.class, new String[] { "clear plot %string% in %world%" });
		 Skript.registerEffect(EffMovePlot.class, new String[] { "move %string% to %string% in %world%" });
		 
		 
		 /*
		  *  PlotMe - Expressions
		  */
		 
		 Skript.registerExpression(ExprPlotAtPlayer.class, String.class, ExpressionType.PROPERTY, new String[] {"plot at %player%"});
		 Skript.registerExpression(ExprPlotAtLoc.class, String.class, ExpressionType.PROPERTY, new String[] {"plot at location %location%"});
		 Skript.registerExpression(ExprGetOwner.class, String.class, ExpressionType.PROPERTY, new String[] {"get owner of %string%"});
		 Skript.registerExpression(ExprGetPlayerPlots.class, String.class, ExpressionType.PROPERTY, new String[] {"plots of %player%"});
		 Skript.registerExpression(ExprTopCorner.class, Location.class, ExpressionType.PROPERTY, new String[] {"(top|upper) corner of %string% in %world%"});
		 Skript.registerExpression(ExprBottomCorner.class, Location.class, ExpressionType.PROPERTY, new String[] {"(bottom|lower) corner of %string% in %world%"});
		 } 
		 
		 /*
		  *  Spawner - Effects
		  */
		 
		 Skript.registerEffect(EffSetSpawner.class, new String[] { "set spawner %location% to %string%" });
		 Skript.registerEffect(EffSetDelay.class, new String[] { "set delay of %location% to %integer%" });
		 Skript.registerEffect(EffMFG_Drop.class, new String[] { "drop a spawner at %location% based on %location%" });
		 Skript.registerEffect(EffMFG_GiveSpawner.class, new String[] { "give a spawner to %player% based on %location%" });
		 Skript.registerEffect(EffMFG_SetSpawner.class, new String[] { "set spawner at %location% to its type" });
		 
		 
		 /*
		  *  Spawner - Expressions
		  */
		 
		 Skript.registerExpression(ExprDelayTime.class, Integer.class, ExpressionType.PROPERTY, new String[] {"delay time of %location%"});
		 Skript.registerExpression(ExprSpawnedType.class, String.class, ExpressionType.PROPERTY, new String[] {"entity type of %location%"});
		 Skript.registerExpression(ExprItemName.class, String.class, ExpressionType.SIMPLE, "item name");
		 
		 pl = getServer().getPluginManager().getPlugin("Towny");
		 
		 if (pl != null) {
		 
		 /*
		  *  Towny - Effects
		  */
		 
		 
		 
		 Skript.registerEffect(EffSetPlotOwner.class, new String[] { "set owner of plot at %location% to %player%" });
		 Skript.registerEffect(EffSetPlotPrice.class, new String[] { "set price of plot at %location% to %double%" });
		 
		 /*
		  *  Towny - Expressions
		  */
		 
		 Skript.registerExpression(ExprTownAtPlayer.class, String.class, ExpressionType.PROPERTY, new String[] {"town at %player%"});
		 Skript.registerExpression(ExprTownOfPlayer.class, Town.class, ExpressionType.PROPERTY, new String[] {"town of %player%"});
		 Skript.registerExpression(ExprTDBank.class, Double.class, ExpressionType.PROPERTY, new String[] {"town balance of %string%"});
		 Skript.registerExpression(ExprTDPlayerCount.class, Integer.class, ExpressionType.PROPERTY, new String[] {"player[ ]count of %string%"});
		 Skript.registerExpression(ExprTDPlayers.class, String.class, ExpressionType.PROPERTY, new String[] {"players of %string%"});
		 Skript.registerExpression(ExprTDTaxes.class, Double.class, ExpressionType.PROPERTY, new String[] {"town taxes of %string%"});
		 Skript.registerExpression(ExprPlotOwner.class, String.class, ExpressionType.PROPERTY, new String[] {"owner of plot at %location%"});
		 Skript.registerExpression(ExprPlotPrice.class, Double.class, ExpressionType.PROPERTY, new String[] {"price of plot at %location%"});
		 Skript.registerExpression(ExprRDLastOnline.class, String.class, ExpressionType.PROPERTY, new String[] {"resident data last online of %player%"});
		 Skript.registerExpression(ExprRDLastOnlineDate.class, String.class, ExpressionType.PROPERTY, new String[] {"resident data last online date of %player%"});
		 Skript.registerExpression(ExprRDChatName.class, String.class, ExpressionType.PROPERTY, new String[] {"resident data chat name of %player%"});
		 Skript.registerExpression(ExprRDFriends.class, String.class, ExpressionType.PROPERTY, new String[] {"resident data friends of %player%"});
		 Skript.registerExpression(ExprRDNationRanks.class, String.class, ExpressionType.PROPERTY, new String[] {"resident data nation ranks of %player%"});
		 Skript.registerExpression(ExprRDRegistered.class, Long.class, ExpressionType.PROPERTY, new String[] {"resident data registered of %player%"});
		 Skript.registerExpression(ExprRDSurname.class, String.class, ExpressionType.PROPERTY, new String[] {"resident data surname of %player%"});
		 Skript.registerExpression(ExprRDTitle.class, String.class, ExpressionType.PROPERTY, new String[] {"resident data title of %player%"});
		 
		 /*
		  *  Towny - Conditions
		  */
		 
		 Skript.registerCondition(CondIsAlly.class, "%string% is ally with %string%", "%string% is(n't| not) ally with %string%");
		 Skript.registerCondition(CondIsNeutral.class, "%string% is neutral", "%string% is(n't| not) neutral");
		 Skript.registerCondition(CondIsEnemy.class, "%string% is enemy with %string%", "%string% is(n't| not) enemy with %string%");
		 }
		 
		 /*
		  *  Misc - Effects
		  */
		 
		 Skript.registerEffect(EffDropAll.class, new String[] { "force drop inventory of %player% at %location%" });
		 Skript.registerEffect(EffImgInChat.class, new String[] { "show %player% image %string% with %string%, %string%, %string%" });
		 Skript.registerEffect(EffImgFromURL.class, new String[] { "show %player% image from %string% with %string%, %string%, %string%" });
		 
		 /*
		  *  Bungee - Effects
		  */
		 if (use_bungee == true) {
			 new Messenger(this);
			 Skript.registerEffect(EffChangeServer.class, new String[] { "send %player% to %string%" });
		 }
		 
		 /*
		  *  Vault - Effects
		  */
		 
		 
		 
		 /*
		  *  Vault - Expressions
		  */

		 
	 }
	 
	 public void loadConfiguration(){
	 	String path = "use_bungee";
	 	getConfig().addDefault(path, false);
	 	getConfig().options().copyDefaults(true);
	 	saveConfig();
	 }
	 	
	 public Boolean use_bungee = getConfig().getBoolean("use_bungee");
	 
	 private static Main inst;
	  
	 public Main() {
		 inst = this;
	 }
	  
	 public static Main getInstance() {
		 return inst;
	 }
}