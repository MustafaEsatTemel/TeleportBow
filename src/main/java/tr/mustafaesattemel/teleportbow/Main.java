package tr.mustafaesattemel.teleportbow;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tr.mustafaesattemel.teleportbow.Commands.GiveCommand;
import tr.mustafaesattemel.teleportbow.Listeners.TeleportBowListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
    getConfig().options().copyDefaults();
    saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new TeleportBowListener(this),this);
        Bukkit.getPluginCommand("givebow").setExecutor(new GiveCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
