package com.borcore;

import com.borcore.command.List;
import com.borcore.command.Main;
import com.borcore.command.Teleport;
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

        getCommand("borcore").setExecutor(new Main());
        getCommand("list").setExecutor(new List());

        Teleport teleport = new Teleport();
        getCommand("tpa").setExecutor(teleport);
        getCommand("tpaccept").setExecutor(teleport);
        getCommand("tpdeny").setExecutor(teleport);

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
