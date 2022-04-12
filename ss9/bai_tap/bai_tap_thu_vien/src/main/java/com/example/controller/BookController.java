package com.example.controller;

import com.example.dto.BookDto;
import com.example.model.Book;
import com.example.model.BorrowedCard;
import com.example.repository.IBorrowedCardRepository;
import com.example.service.IBookService;
import com.example.service.IBorrowedCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBorrowedCardService iBorrowedCardService;

    @GetMapping({"", "list"})
    public String goList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword, @ModelAttribute Book book) {
        String keywordValue = keyword.orElse("");
        Page<Book> books;
        if (keyword.isPresent()) {
            books = iBookService.findByName(keywordValue, pageable);
        } else {
            books = iBookService.findAllBook(pageable);
        }
        model.addAttribute("books", books);
        model.addAttribute("keywordValue", keywordValue);
        return "list";
    }

    @GetMapping("borrow/{id}")
    public String borrow(@PathVariable Integer id, Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("book", book);
        return "borrowBook";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("book") Book book, Model model) {
        BorrowedCard borrowedCard = new BorrowedCard();
        borrowedCard.setBook(book);
        book.setQuantity((book.getQuantity() - 1));
        iBorrowedCardService.save(borrowedCard);
        iBookService.save(book);
        return "redirect:/list";
    }

    @GetMapping("remove")
    public String delete(@RequestParam Integer idBorrow,@RequestParam Integer id){
        iBorrowedCardService.deleteById(idBorrow);
        Book book = iBookService.findById(id);
        book.setQuantity((book.getQuantity() + 1));
        iBookService.save(book);
        return "redirect:/list";
    }
    @ExceptionHandler(Exception.class)
    public String go404(){
        return "error";
    }
}
