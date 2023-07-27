package com.example.songapplication.dto;

public class SongDto {
    private int id;
    private String name;
    private String nameSinger;
    private String type;

    public SongDto() {
    }

    public SongDto(int id, String song, String nameSinger, String type) {
        this.id = id;
        this.name = song;
        this.nameSinger = nameSinger;
        this.type = type;
    }

    public SongDto(String song, String nameSinger, String type) {
        this.name = song;
        this.nameSinger = nameSinger;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
