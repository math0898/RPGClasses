package io.github.math0898.rpgclasses.classes;

import io.github.math0898.rpgframework.damage.DamageResistance;
import io.github.math0898.rpgframework.damage.DamageType;
import org.bukkit.entity.Player;

import java.util.EnumMap;
import java.util.Map;

/**
 * This class describes the ghost class as a whole. A sudo admin class developed for Sylixyy since well he lost a lot of
 * things and was mod for... a day.
 *
 * @author Sugaku
 */
public class Ghost extends Archetype {

    //todo GhostlyCharge, Icy Touch,

    /**
     * The static resistance map for the Ghost class. This way it doesn't need to be reconstructed every time someone
     * grabs the resistance map.
     */
    private static Map<DamageType, DamageResistance> resistanceMap = null;

    /**
     * Gets the table of damage resistances for this Archetype. If a damage type is not in this map then its assumed
     * that players with this class take normal damage from that source. Ghosts have immunity to physical damage and a
     * vulnerability to fire and holy damage.
     *
     * @return The Map of damage resistances for this class.
     */
    @Override
    public Map<DamageType, DamageResistance> getResistances() {
        if (resistanceMap != null) return resistanceMap;
        Map<DamageType, DamageResistance> r = new EnumMap<>(DamageType.class);
        r.put(DamageType.IMPACT, DamageResistance.IMMUNITY);
        r.put(DamageType.PUNCTURE, DamageResistance.IMMUNITY);
        r.put(DamageType.SLASH, DamageResistance.IMMUNITY);
        r.put(DamageType.FIRE, DamageResistance.VULNERABILITY);
        r.put(DamageType.HOLY, DamageResistance.VULNERABILITY);
        resistanceMap = r;
        return resistanceMap;
    }
}
