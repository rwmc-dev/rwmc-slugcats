package dev.rwmc.slugcatsplugin.listeners;

import dev.rwmc.slugcatsplugin.Utilities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Utilities.updatePlayerDisplay(player);
    }
}
