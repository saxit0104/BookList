package com.example.booklist.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.booklist.Book;

@Controller
public class BookDelete {

    @Autowired
    DeleteService service;
    /**
     * データベース削除
     * @param model
     * @param Book
     * @return
     */
    @GetMapping("/book-delete")
    public String deleteBook(Model model, Book Book, BindingResult result) {
    	
    	service.delete(Book.getId());
    	
    	return "redirect:/book-list";
    }
}
