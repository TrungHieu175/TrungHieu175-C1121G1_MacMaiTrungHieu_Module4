package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping({"", "list"})
    public String goView(Model model) {

        List<Blog> blogList = iBlogService.findAll();

        model.addAttribute("list", blogList);

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
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id,Model model){
        iBlogService.deleteById(id);
        return "redirect:/list";
    }


}
