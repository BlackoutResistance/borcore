package com.borcore.data;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class Settings {

    private String path, header;
    private File file;
    private YamlConfiguration configuration;

    Settings(String path, File file) {
        this.path = path;
        this.file = file;

        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void useHeader(String header) {
        this.path = path + "." + (this.header = header);
    }

    public void save() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void set(String name, Object defaultValue) {
        configuration.set(path + "." + name, defaultValue);
    }

    <T> T get(String name, Class<T> clazz) {
        return clazz.cast(configuration.get(path + "." + name));
    }

    void remove(String name) {
        configuration.set(path + "." + name, null);
    }

}
