package com.borcore.data;

public class PlayerSettings extends Settings {

    private final String nameId = "name";
    private final String factionId = "faction";


    public PlayerSettings() {
        super("player", ConfigFiles.PLAYER.getFile());
    }

    public void setFaction(String factionName) {
        set(factionId, factionName);
    }

    public void getFaction() {
        get(factionId, String.class);
    }

    public void setCustomName(String name) {
        set(nameId, name);
    }

    public String getName() {
        return get(nameId, String.class);
    }

}
