/*
 * ExprClickedItem.class - Made by Funnygatt
 * nfell2009.uk (C) nfell2009 | 2014 - 2015
 * Submitted to: Umbaska
 * 
*/


package uk.co.umbaska.GattSk.Expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

public class ExprSpawnReason extends SimpleExpression<String>{

	private Expression<Entity> entity;
	
	public Class<? extends String> getReturnType() {
		
		return String.class;
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2, ParseResult arg3) {
		this.entity = (Expression<Entity>) args[0];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "entity spawn reason";
	}

	@Override
	@javax.annotation.Nullable
	protected String[] get(Event arg0) {
		Entity e = this.entity.getSingle(arg0);
		String out = null;
		if (e.hasMetadata("spawnreason")) {
			out = e.getMetadata("spawnreason").toString();
		} else {
			return null;
		}

		return new String[] { out };
	}

}