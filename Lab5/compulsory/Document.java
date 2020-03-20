package com.lab5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Clasa ce descrie un document care poate fi o carte, un articol, etc
 */
public class Document implements Serializable {
    private String id;
    private String name;
    private String location;
    private Map<String, Object> tags;

    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        tags = new HashMap<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    /**
     * Adauga un tag documentului curent (perechi key - value)
     * @param key cheia din pereche (key)
     * @param obj valoare din pereche (value)
     */
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}
