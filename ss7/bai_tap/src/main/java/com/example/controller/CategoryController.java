package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("view")
    public String goView(Model model) {

        List<Category> categoryList = iCategoryService.findAll();

        model.addAttribute("view", categoryList);

        return "view";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(Category category) {
        iCategoryService.save(category);
        return "redirect:/view";
    }

    @GetMapping("editCategory/{id}")
    public String editCategory(@PathVariable Integer id, Model model) {
        Category categoryEdit = iCategoryService.findById(id);
        model.addAttribute("category", categoryEdit);
        return "editCategory";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Integer id, Model model) {
        iCategoryService.deleteById(id);
        return "redirect:/view";
    }
}
