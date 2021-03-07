package com.github.chaosindustory.barbedwire;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public final class BarbedWire extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Coral(), this);
        Bukkit.getLogger().info("BarbedWire becomes valid!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("BarbedWire becomes invalid!");
    }
}
