package com.controller;

import com.model.Declaration;
import com.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeclarationController {

    @Autowired
    IDeclarationService iDeclarationService;

    @GetMapping({"", "/declaration"})
    public String showForm(Model model) {

        List<String> gender = iDeclarationService.getAllGender();

        List<String> nationality = iDeclarationService.getAllNationality();

        model.addAttribute("gender", gender);

        model.addAttribute("nationality", nationality);

        model.addAttribute("declaration", new Declaration());

        return "declaration";
    }

    @PostMapping("/declaration")
    public String submit(@ModelAttribute Declaration declaration, Model model) {

        iDeclarationService.save(declaration);

        model.addAttribute("declaration", declaration);

        model.addAttribute("mess", "Thành Công");

        List<String> gender = iDeclarationService.getAllGender();

        List<String> nationality = iDeclarationService.getAllNationality();

        model.addAttribute("gender", gender);

        model.addAttribute("nationality", nationality);

        return "declaration";
    }

}
