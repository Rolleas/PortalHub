package me.towercraft.rolles.portalhub.event;

import org.bukkit.Material;
import me.towercraft.rolles.portalhub.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PortalEnterEvent implements Listener {
    HashMap<String, Boolean> players = new HashMap<>();

    private boolean checkPlayerInPortal(Player player) {
        Material material = player.getLocation().getBlock().getType();
        return material == Material.PORTAL;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMovePlayer(PlayerMoveEvent event) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            if (checkPlayerInPortal(event.getPlayer())) {
                event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().setY(0).normalize().multiply(-5));
                players.put(event.getPlayer().getName(), true);
            }
        }, 5);
        if (!checkPlayerInPortal(event.getPlayer())) {
            if (players.containsKey(event.getPlayer().getName()) && players.get(event.getPlayer().getName())) {
                players.remove(event.getPlayer().getName());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                    event.getPlayer().performCommand("gui open servers");
                }, 5);
            }
        }
    }
}
