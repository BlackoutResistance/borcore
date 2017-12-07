package com.borcore;

import org.bukkit.plugin.java.JavaPlugin;

public class BORCore extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(getName() + " enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info(getName() + " disabled.");
    }

}
