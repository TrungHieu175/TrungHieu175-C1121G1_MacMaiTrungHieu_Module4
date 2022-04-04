package com.controller;

import com.model.Music;
import com.servicer.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MusicController {

    @Autowired
    IMusicService iMusicService;

    @GetMapping({"", "/list"})
    public ModelAndView goMusic() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Music> listMusic = iMusicService.findAll();
        modelAndView.addObject("musicList",listMusic);
        return modelAndView;
    }


}
