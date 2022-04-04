package com.codegym.controller;

import com.codegym.model.Mail;
import com.codegym.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {

    @Autowired
    IMailService iMailService;

    @GetMapping({"","/view"})
    public String goView(Model model){
        Mail mail = iMailService.getMail();
        model.addAttribute("mail", mail);
        return "view";
    }

    @PostMapping("/view")
    public String update(@ModelAttribute Mail mail, Model model){
        iMailService.save(mail);
        model.addAttribute("mail",mail);
        return "view";
    }
}
