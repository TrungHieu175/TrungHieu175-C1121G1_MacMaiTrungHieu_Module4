package com.controller;

import com.model.Picture;
import com.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PictureController {
    @Autowired
    private IPictureService iPictureService;

    @GetMapping({"","/picture"})
    public String goIndex(Model model){
        List<Picture> pictureList = iPictureService.getAllPicture();
        model.addAttribute("picture",new Picture());
        model.addAttribute("pictureList",pictureList);
        return "index";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("picture") Picture picture, Model model){
        iPictureService.createPicture(picture);
        return "redirect:/picture";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") Integer id){
        Picture picture = iPictureService.findPictureById(id);
        iPictureService.increateLike(picture);
        return "redirect:/picture";
    }
}
