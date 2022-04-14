package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("view")
    public ResponseEntity<List<Category>> goCategory() {

        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCatrgoryById(@PathVariable Integer id) {
        Optional<Category> categoryOptional = iCategoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody Category category) {
        iCategoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCustomer(@PathVariable Integer id, @RequestBody Category category) {
        Optional<Category> categoryOptional = iCategoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryOptional.get().getId());
        iCategoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
