package com.example.controller;

import com.example.dto.SaveNoteDto;
import com.example.model.Customer;
import com.example.model.SaveNote;
import com.example.service.ICustomerService;
import com.example.service.ISaveNoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class SaveNoteController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ISaveNoteService iSaveNoteService;

    @GetMapping({"", "listSaveNote"})
    public String goList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword,@ModelAttribute SaveNoteDto saveNoteDto) {
        String keywordValue = keyword.orElse("");
        Page<SaveNote> saveNotes;
        if (keyword.isPresent()) {
            saveNotes = iSaveNoteService.findByName(keywordValue, pageable);
        } else {
            saveNotes = iSaveNoteService.findAllSaveNote(pageable);
        }
        model.addAttribute("saveNotes", saveNotes);
        model.addAttribute("keywordValue", keywordValue);
        return "listSaveNote";
    }

    @GetMapping("addSaveNote")
    public String addSaveNote(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList", customerList);
        model.addAttribute("saveNote", new SaveNoteDto());
        return "addSaveNote";
    }

    @GetMapping("edit/{id}")
    public String editSaveNote(@PathVariable Integer id, Model model) {
        SaveNote saveNote = iSaveNoteService.findById(id);
        List<Customer> customerList = iCustomerService.findAll();
        SaveNoteDto saveNoteDto = new SaveNoteDto();
        BeanUtils.copyProperties(saveNote,saveNoteDto);
        model.addAttribute("customerList", customerList);
        model.addAttribute("saveNote", saveNoteDto);
        return "editSaveNote";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("saveNote") SaveNoteDto saveNoteDto , BindingResult bindingResult, Model model ) {
        new SaveNoteDto().validate(saveNoteDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customerList",iCustomerService.findAll());
            return "addSaveNote";
        }else {
            SaveNote saveNote = new SaveNote();
            BeanUtils.copyProperties(saveNoteDto,saveNote);
            iSaveNoteService.save(saveNote);
            return "redirect:/listSaveNote";
        }

    }

    @GetMapping("/remove")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam Integer id){
        iSaveNoteService.deleteById(id);
        return "redirect:/listSaveNote";
    }

}
