package uk.nfell2009.umbaska.v1_8.ArmorStands;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 12/2/2014.
 */
public class ExprsGravity extends SimplePropertyExpression<Entity, Boolean> {
	@Override
	public Boolean convert(Entity ent) {
		if(ent == null)
			return null;
		return ((ArmorStand)ent).hasGravity();
	}

	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
		Entity ent = getExpr().getSingle(e); //Called to get the Target which is Player in this case.
		if(ent == null)
			return;
		if(ent.getType() != EntityType.ARMOR_STAND){
			return;
		}
		Boolean b = (Boolean) (delta[0]);
		if (mode == Changer.ChangeMode.SET){
			((ArmorStand)ent).setGravity(b);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
		if (mode == Changer.ChangeMode.SET) //SET can be replaced with REMOVE ADD or similiar stuff.
			return CollectionUtils.array(Boolean.class); //The Class should be the TypeToGet and in this case Number.
		if (mode == Changer.ChangeMode.REMOVE)
			return CollectionUtils.array(Boolean.class);
		return null;
	}

	@Override
	public Class<? extends Boolean> getReturnType() { //ReturnType is TypeToGet and in this case Number.
		return Boolean.class;

	}
	@Override
	protected String getPropertyName() {
		// TODO Auto-generated method stub
		return "gravity";
	}

}
