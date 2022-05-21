package me.towercraft.rolles.portalhub;

import me.towercraft.rolles.portalhub.event.PortalEnterEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PortalEnterEvent(), this);
    }

    @Override
    public void onDisable() {

    }
}
