package com.example.bai_tap_validate.controller;

import com.example.bai_tap_validate.dto.UserDto;
import com.example.bai_tap_validate.model.User;
import com.example.bai_tap_validate.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping({"", "listSaveNote"})
    public String goList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword, @ModelAttribute User user) {
        String keywordValue = keyword.orElse("");
        Page<User> userPage;
        if (keyword.isPresent()) {
            userPage = iUserService.findByName(keywordValue, pageable);
        } else {
            userPage = iUserService.findAllByName(pageable);
        }
        model.addAttribute("saveNotes", userPage);
        model.addAttribute("keywordValue", keywordValue);
        return "listSaveNote";
    }

    @GetMapping("addSaveNote")
    public String addSaveNote(Model model) {
        List<User> userList = iUserService.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("userDto", new UserDto());
        return "addSaveNote";
    }

    @GetMapping("edit/{id}")
    public String editSaveNote(@PathVariable Integer id, Model model) {
        SaveNote saveNote = iSaveNoteService.findById(id);
        List<Customer> customerList = iCustomerService.findAll();
        SaveNoteDto saveNoteDto = new SaveNoteDto();
        BeanUtils.copyProperties(saveNote, saveNoteDto);
        model.addAttribute("customerList", customerList);
        model.addAttribute("saveNote", saveNoteDto);
        return "editSaveNote";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("saveNote") UserDto userDto, BindingResult bindingResult, Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addSaveNote";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            return "redirect:/listSaveNote";
        }

    }

    @GetMapping("/remove")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam Integer id) {
        iUserService.deleteById(id);
        return "redirect:/listSaveNote";
    }


    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id, Model model) {
        iSaveNoteService.deleteById(id);
        return "redirect:/listSaveNote";
    }
}
