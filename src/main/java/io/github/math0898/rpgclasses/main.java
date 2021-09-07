package io.github.math0898.rpgclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * The main class of RPGClasses, that plugin that does all of that classes stuffs.
 *
 * @author Sugaku
 */
public final class main extends JavaPlugin {

    /**
     * A pointer to the JavaPlugin instance.
     */
    public static JavaPlugin plugin = null;

    /**
     * Helper method for sending messages to console. Needed mostly because we can't guarantee a hook into RPGFramework.
     *
     * @param message The message to send.
     * @param color The color to send the message in.
     * @param level The level to send the message in.
     */
    public static void console (String message, ChatColor color, Level level) {
        plugin.getLogger().log(level, color + message);
    }

    /**
     * The enable function of our plugin. Mostly used to register listeners and make sure that RPG-Framework is
     * installed and functioning properly.
     */
    @Override
    public void onEnable() {

        plugin = this;

        if (Bukkit.getPluginManager().getPlugin("RPGFramework") == null) {
            console("Could not find RPG-Framework. Is it installed?", ChatColor.RED, Level.SEVERE);
            getServer().getPluginManager().disablePlugin(this);
        }
    }
}
