package com.borcore.data;

import com.borcore.BORCore;

import java.io.File;
import java.io.IOException;

public enum ConfigFiles {

    PLAYER(BORCore.getPluginFolder() + File.separator + "player-data.yml"),
    SERVER(BORCore.getPluginFolder() + File.separator + "config.yml");

    private String path;
    private File file;

    ConfigFiles(String path) {
        this.path = path;

        try {
            (file = new File(path)).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }

}
