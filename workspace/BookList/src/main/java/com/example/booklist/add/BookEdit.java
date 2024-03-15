package com.example.booklist.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.booklist.insert.EditBookForm;

@Controller
public class BookEdit {

    @Autowired
    AddService service;
    /**
     * 本の編集をする
     * @param model
     * @param editBook
     * @return
     */
    @GetMapping("/book-edit")
    public String editBook(Model model, EditBookForm editBook) {
    	
    	editBook = service.getOneBook(editBook.getId());
    	model.addAttribute(editBook);
    	
    	return "edit";
    }
    
    /**
     * 本の削除をする
     * @param editBook
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/book-edit")
    public String update(@ModelAttribute @Validated 
    		EditBookForm editBook, BindingResult result, Model model) {
    	
    	if(result.hasErrors()) {
    		return "edit";
    	}
    	
    	service.update(editBook);
    	
    	return "redirect:/book-list";
    }
}
