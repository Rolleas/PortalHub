package me.towercraft.rolles.portalhub.event;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PortalEnterEvent implements Listener {
    @EventHandler
    public void onEnterPortal(PlayerPortalEvent event) {
        Player enteredPlayer = event.getPlayer();
        enteredPlayer.setVelocity(enteredPlayer.getLocation().getDirection().multiply(-1));
        enteredPlayer.performCommand("gui open servers");
    }
}
