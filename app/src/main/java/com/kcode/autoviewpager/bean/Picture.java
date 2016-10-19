package com.kcode.autoviewpager.bean;

/**
 * Created by caik on 2016/10/19.
 */

public class Picture {
    private String path;
    private String name;

    public Picture(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
