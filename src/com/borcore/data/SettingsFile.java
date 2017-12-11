package com.borcore.data;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SettingsFile {

    private File file;
    private YamlConfiguration config;

    SettingsFile(String directory) {
        file = new File(directory);
        file.getParentFile().mkdirs();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    void set(String path, Object value) {
        config.set(path, value);
    }

    void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
