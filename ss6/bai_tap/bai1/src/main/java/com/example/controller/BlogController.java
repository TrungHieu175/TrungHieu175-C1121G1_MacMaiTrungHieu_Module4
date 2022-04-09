package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping({"", "list"})
    public String goList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<Integer> keyword) {
        Integer keywordValue = keyword.orElse(null);
        Page<Blog> blogPage;
        if (keyword.isPresent()) {
            blogPage = iBlogService.findAllById(keywordValue, pageable);
        } else {
            blogPage = iBlogService.findAllOderBy(pageable);
        }
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("keywordValue", keywordValue);
        return "list";
    }

    @GetMapping("addBlog")
    public String addBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "addBlog";
    }

    @GetMapping("edit/{id}")
    public String editBlog(@PathVariable Integer id, Model model) {
        Blog blogEdit = iBlogService.findById(id);
        model.addAttribute("blog", blogEdit);
        return "editBlog";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("/remove")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam Integer id) {
        iBlogService.deleteById(id);
        return "redirect:/list";
    }
}
