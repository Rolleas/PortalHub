package me.towercraft.rolles.portalhub.event;

import me.towercraft.rolles.portalhub.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PortalEnterEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEnterPortal(PlayerPortalEvent event) {
        Player player = event.getPlayer();
        player.setVelocity(player.getLocation().getDirection().setY(0).normalize().multiply(-2));
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            player.chat("/gui open servers");
        }, 5);
    }
}
