package com.example.songapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nameSinger;
    private String type;

    public Song() {
    }

    public Song(int id, String name, String nameSinger, String type) {
        this.id = id;
        this.name = name;
        this.nameSinger = nameSinger;
        this.type = type;
    }

    public Song(String name, String nameSinger, String type) {
        this.name = name;
        this.nameSinger = nameSinger;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
