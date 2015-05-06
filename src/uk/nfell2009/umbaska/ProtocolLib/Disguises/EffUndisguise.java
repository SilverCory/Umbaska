package uk.nfell2009.umbaska.ProtocolLib.Disguises;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 5/6/2015.
 */
public class EffUndisguise extends Effect {

    private Expression<Player> player;

    @Override
    protected void execute(Event event){
        Player[] p = player.getAll(event);
        if (p == null) {
            return;
        }

        for (Player pl : p) {
            MyDisguise disguise = new MyDisguise(pl, EntityDisguise.BAT);
            try {
                disguise.removeDisguise();
            }catch (ReflectiveOperationException expect){
                expect.printStackTrace();
            }
        }
    }


    @Override
    public String toString(Event event, boolean b){
        return "Hide Entity";
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
        player = (Expression<Player>) expressions[0];
        return true;
    }
}
