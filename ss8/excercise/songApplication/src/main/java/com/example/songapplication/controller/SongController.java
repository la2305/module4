package com.example.songapplication.controller;

import com.example.songapplication.dto.SongDto;
import com.example.songapplication.model.Song;
import com.example.songapplication.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping("/list")
    public String showList(Model model){
        List<Song> songList =songService.findAll();
        model.addAttribute("songList",songList);
        return "/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        SongDto songDto = new SongDto();
        model.addAttribute("songDto",songDto);
        return "/create";
    }

}
