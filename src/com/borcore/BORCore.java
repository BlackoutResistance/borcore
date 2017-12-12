package com.borcore;

import com.borcore.event.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class BORCore extends JavaPlugin {

    private static JavaPlugin plugin;
    private static File dataFolder;

    @Override
    public void onEnable() {
        plugin = this;
        dataFolder = getDataFolder();

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        getLogger().info(getName() + " enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info(getName() + " disabled.");
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static File getPluginFolder() {
        return dataFolder;
    }

}
