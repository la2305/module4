package com.example.songapplication.service;

import com.example.songapplication.model.Song;
import com.example.songapplication.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public boolean addSong(Song song) {
        if (song!=null){
            songRepository.save(song);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Song selectById(int id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void editSong(Song song) {
        songRepository.save(song);
    }
}
