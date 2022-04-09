package com.example.bai_tap_validate.controller;

import com.example.bai_tap_validate.dto.UserDto;
import com.example.bai_tap_validate.model.User;
import com.example.bai_tap_validate.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping({"", "listUser"})
    public String goList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<User> userPage;
        if (keyword.isPresent()) {
            userPage = iUserService.findByName(keywordValue, pageable);
        } else {
            userPage = iUserService.findAllByName(pageable);
        }
        model.addAttribute("userPage", userPage);
        model.addAttribute("keywordValue", keywordValue);
        return "listUser";
    }

    @GetMapping("addUser")
    public String addSaveNote(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "addUser";
    }

    @GetMapping("edit/{id}")
    public String editSaveNote(@PathVariable Integer id, Model model) {
        User user = iUserService.findById(id);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        model.addAttribute("userDto", userDto);
        return "editUser";
    }

    @PostMapping("/save")
    public String save(@Validated UserDto userDto, BindingResult bindingResult, Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addUser";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            return "redirect:/listUser";
        }

    }

    @GetMapping("/remove")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam Integer id) {
        iUserService.deleteById(id);
        return "redirect:/listUser";
    }

}
