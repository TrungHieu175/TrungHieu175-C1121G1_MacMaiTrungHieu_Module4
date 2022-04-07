package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
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

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;


    @GetMapping({"", "list"})
    public String goList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Blog> blogPage;
        if (keyword.isPresent()) {
            blogPage = iBlogService.findAllPaging(keywordValue, pageable);
        } else {
            blogPage = iBlogService.findAllBlog(pageable);
        }
        model.addAttribute("list", blogPage);
        model.addAttribute("keywordValue", keywordValue);
        return "list";
    }

    @GetMapping("addBlog")
    public String addBlog(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "addBlog";
    }

    @GetMapping("edit/{id}")
    public String editBlog(@PathVariable Integer id, Model model) {
        Blog blogEdit = iBlogService.findById(id);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blogEdit);
        return "editBlog";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id, Model model) {
        iBlogService.deleteById(id);
        return "redirect:/list";
    }

}
