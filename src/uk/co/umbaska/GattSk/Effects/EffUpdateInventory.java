/*
 * EffUpdateInventory.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 | 2014 - 2015
 * Submitted to: Umbaska
 * 
*/


package uk.co.umbaska.GattSk.Effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffUpdateInventory extends Effect {
	private Expression<Player[]> players;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2,
						SkriptParser.ParseResult arg3) {

		this.players = (Expression<Player[]>) args[0];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "create new objective";
	}

	@Override
	protected void execute(Event arg0) {
		Player[] players = this.players.getSingle(arg0);
		for (Player p : players){
			p.updateInventory();
		}
	}

}

