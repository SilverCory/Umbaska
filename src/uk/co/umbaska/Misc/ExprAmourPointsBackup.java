/*
 * ExprAmourPointsBackup.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 | 2014 - 2015
 * Submitted to: Umbaska
 * 
*/

package uk.co.umbaska.Misc;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class ExprAmourPointsBackup extends SimpleExpression<Double>{

	private Expression<Player> player;
	
	public Class<? extends Double> getReturnType() {
		
		return Double.class;
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2, ParseResult arg3) {
		this.player = (Expression<Player>) args[0];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "return plot id at location";
	}

	@Override
	@javax.annotation.Nullable
	protected Double[] get(Event arg0) {

		Player p = this.player.getSingle(arg0);
		
		if (p == null){
			return null;
		}
		org.bukkit.inventory.PlayerInventory inv = p.getInventory();
		ItemStack boots = inv.getBoots();
		ItemStack helmet = inv.getHelmet();
		ItemStack chest = inv.getChestplate();
		ItemStack pants = inv.getLeggings();
        double red = 0.0;
        if (boots != null) {
        	if(boots.getType() == Material.LEATHER_HELMET) {
        		red = red + 0.04;
        	} else if(boots.getType() == Material.GOLD_HELMET) {
        		red = red + 0.08;
        	} else if(boots.getType() == Material.CHAINMAIL_HELMET) {
        		red = red + 0.08;
        	} else if(boots.getType() == Material.IRON_HELMET) {
        		red = red + 0.08;
        	} else if(boots.getType() == Material.DIAMOND_HELMET) {
        		red = red + 0.12;
        	}
        }
        if (chest != null) {
        	if(chest.getType() == Material.LEATHER_HELMET) {
        		red = red + 0.04;
        	} else if(chest.getType() == Material.GOLD_HELMET) {
        		red = red + 0.08;
        	} else if(chest.getType() == Material.CHAINMAIL_HELMET) {
        		red = red + 0.08;
        	} else if(chest.getType() == Material.IRON_HELMET) {
        		red = red + 0.08;
        	} else if(chest.getType() == Material.DIAMOND_HELMET) {
        		red = red + 0.12;
        	}
        }
        if (helmet != null) {
        	if(helmet.getType() == Material.LEATHER_HELMET) {
        		red = red + 0.04;
        	} else if(helmet.getType() == Material.GOLD_HELMET) {
        		red = red + 0.08;
        	} else if(helmet.getType() == Material.CHAINMAIL_HELMET) {
        		red = red + 0.08;
        	} else if(helmet.getType() == Material.IRON_HELMET) {
        		red = red + 0.08;
        	} else if(helmet.getType() == Material.DIAMOND_HELMET) {
        		red = red + 0.12;
        	}
        }
        if (pants != null) {
        	if(pants.getType() == Material.LEATHER_HELMET) {
        		red = red + 0.04;
        	} else if(pants.getType() == Material.GOLD_HELMET) {
        		red = red + 0.08;
        	} else if(pants.getType() == Material.CHAINMAIL_HELMET) {
        		red = red + 0.08;
        	} else if(pants.getType() == Material.IRON_HELMET) {
        		red = red + 0.08;
        	} else if(pants.getType() == Material.DIAMOND_HELMET) {
        		red = red + 0.12;
        	}
        }
		return new Double[] { red };
	}

}