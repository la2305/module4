package com.example.songapplication.repository;

import com.example.songapplication.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISongRepository extends JpaRepository<Song,Integer> {
}
