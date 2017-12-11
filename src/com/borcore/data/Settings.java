package com.borcore.data;

import java.util.HashMap;
import java.util.Map;

public abstract class Settings {

    private String path;
    private Map<String, Object> settingsMap = new HashMap<>();
    private SettingsFile settingsFile;

    Settings(String path) {
        this.path = path;
    }

    public void useHeader(String header) {
        this.path = path + "." + header;
    }

    void useSettingsFile(SettingsFile settingsFile) {
        this.settingsFile = settingsFile;
    }

    public void save() {
        settingsMap.keySet().forEach(a -> settingsFile.set(a, settingsMap.get(a)));
        settingsFile.save();
    }

    void set(String name, Object defaultValue) {
        settingsMap.put(path + "." + name, defaultValue);
    }

    <T> T get(String name, Class<T> clazz) {
        return clazz.cast(settingsMap.get(path + "." + name));
    }

    void remove(String name) {
        settingsMap.remove(path + "." + name);
    }

}
