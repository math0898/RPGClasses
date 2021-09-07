package io.github.math0898.rpgclasses.classes;

import io.github.math0898.rpgframework.damage.DamageResistance;
import io.github.math0898.rpgframework.damage.DamageType;
import org.bukkit.event.Listener;

import java.util.Map;

/**
 * An abstract class that describes some useful features for all classes.
 *
 * @author Sugaku
 */
public abstract class Archetype implements Listener {

    /**
     * Gets the table of damage resistances for this Archetype. If a damage type is not in this map then its assumed
     * that players with this class take normal damage from that source.
     *
     * @return The Map of damage resistances for this class.
     */
    public abstract Map<DamageType, DamageResistance> getResistances ();
}
