package com.example.songapplication.controller;

import com.example.songapplication.dto.SongDto;
import com.example.songapplication.model.Song;
import com.example.songapplication.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String showCreate(Model model){
        SongDto songDto = new SongDto();
        model.addAttribute("songDto",songDto);
        return "/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes){
        Song song = new Song();
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            return "/create";
        }
        BeanUtils.copyProperties(songDto,song);
        boolean check = songService.addSong(song);
        if (check){
            redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
            return "redirect:/list";
        }else {
            redirectAttributes.addFlashAttribute("msg","thêm mới không thành công");
            return "redirect:/list";
        }
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Song song = songService.selectById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute SongDto songDto,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            return "/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        boolean check = songService.addSong(song);
        if (check){
            redirectAttributes.addFlashAttribute("msg","Chỉnh sửa thành công");
            return "redirect:/list";
        }else {
            redirectAttributes.addFlashAttribute("msg","Chỉnh sửa thất bại");
            return "redirect:/list";
        }
    }

}
