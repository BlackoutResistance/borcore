package com.borcore.data;

import com.borcore.BORCore;

import java.io.File;
import java.util.UUID;

public class PlayerSettings extends Settings {

    private final String uuidId = "uuid";
    private final String nameId = "name";

    private SettingsFile settingsFile;

    public PlayerSettings() {
        super("player");

        settingsFile = new SettingsFile(BORCore.getPluginFolder() + File.separator + "player-data.yml");
        useSettingsFile(settingsFile);
    }

    public void setUUID(UUID uuid) {
        set(uuidId, uuid);
    }

    public UUID getUUID() {
        return get(uuidId, UUID.class);
    }

    public void setName(String name) {
        set(nameId, name);
    }

    public String getName() {
        return get(nameId, String.class);
    }

}
