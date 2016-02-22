package com.example.zhaoting.qiandao.utils.file;

/**
 * Created by zhaoting on 16/1/18.
 */
public class FileManager {
    private static FileManager manager;

    public static FileManager getManager() {
        if (manager == null) {
            manager = new FileManager();
        }
        return manager;
    }

    public FileManager() {
    }
}
