package io.github.math0898.rpgclasses;

import io.github.math0898.rpgframework.damage.AdvancedDamageEvent;
import io.github.math0898.rpgframework.main;
import io.github.math0898.rpgclasses.classes.Archetype;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The class which well... manages all the classes. This includes tracking which class a player has for the sake of
 * damage calculations.
 *
 * @author Sguaku
 */
public class ClassManager implements Listener {

    /**
     * The ArrayList of classes registered to the plugin.
     */
    private final ArrayList<Archetype> registeredClasses = new ArrayList<>();

    /**
     * This is a map of players and their currently registered class.
     */
    private final Map<Player, Archetype> playerClasses = new HashMap<>();

    /**
     * Returns the list of currently registered classes.
     *
     * @return The ArrayList<Archetype> holding all classes.
     */
    public ArrayList<Archetype> getRegisteredClasses () {
        return registeredClasses;
    }

    /**
     * Returns the Map of players and their registered classes.
     *
     * @return The Map<Player, Archetype> declaring player classes.
     */
    public Map<Player, Archetype> getPlayerClasses () {
        return playerClasses;
    }

    /**
     * Registers a class to the class manager. Also registers event listeners so plugins don't need to worry about doing
     * that themselves.
     *
     * @param archetype The class to register.
     */
    public void registerClass (Archetype archetype) {
        registeredClasses.add(archetype);
        Bukkit.getPluginManager().registerEvents(archetype, main.plugin);
    }

    /**
     * The event listener for the advanced damage event thrown by RPGFramework. We need to add in our damage resistance
     * map that a player possessing a class may have.
     *
     * @param event The advanced damage event.
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onAdvancedDamage (AdvancedDamageEvent event) {
        if (event.getEntity() instanceof  Player) event.setResistances(playerClasses.get((Player) event.getEntity()).getResistances());
    }
}
