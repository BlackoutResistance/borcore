package com.borcore.player;

import com.borcore.data.PlayerSettings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class VirtualPlayer {

    private UUID uuid;
    private PlayerSettings settings = new PlayerSettings();

    private VirtualPlayer(UUID uuid) {
        this.uuid = uuid;
        settings.useHeader(uuid.toString());
        settings.setName(getPlayer().getName());
        settings.save();
    }

    public static VirtualPlayer load(UUID uuid) {
        return new VirtualPlayer(uuid);
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

}
