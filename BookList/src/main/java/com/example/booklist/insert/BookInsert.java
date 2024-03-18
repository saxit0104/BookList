package com.example.booklist.insert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookInsert {
	
    @Autowired
    InsertService service;
	
    /**
     * 新規登録画面を表示
     * @param model
     * @return 新規登録画面
     */
    @GetMapping("/book-create")
    public String createBook(Model model) {

        model.addAttribute("bookForm", new BookForm());

        return "add";
    }
	
    /**
     * データベースに本を登録する
     * @param bookForm
     * @param model
     * @return
     */
    @PostMapping("/book-create")
    public String saveBook(@ModelAttribute @Validated BookForm bookForm, 
    		BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		
    		return "add";
    	}
        // 本を登録する
        service.insert(bookForm);
        // 本の一覧表示画面にリダイレクト
        return "redirect:/book-list";
    }

}
