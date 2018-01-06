package com.borcore.event;

import com.borcore.player.VirtualPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        VirtualPlayer.load(event.getPlayer().getUniqueId());
    }

}
