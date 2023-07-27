package com.example.songapplication.service;

import com.example.songapplication.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    boolean addSong(Song song);
    Song selectById(int id);
    void editSong(Song song);
}
