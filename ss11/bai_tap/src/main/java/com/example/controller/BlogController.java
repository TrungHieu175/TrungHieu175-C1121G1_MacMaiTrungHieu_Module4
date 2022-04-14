package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;


    @GetMapping({"", "list"})
    public ResponseEntity<Page<Blog>> goList(@PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Blog> blogPage = this.iBlogService.findAllPaging(keywordValue, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @PostMapping("addBlog")
    public ResponseEntity<Void> addBlog(@RequestBody Blog blog) {
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Void> editBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Integer id) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.deleteById(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }
}
