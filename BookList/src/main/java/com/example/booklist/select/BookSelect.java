package com.example.booklist.select;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.booklist.Book;
import com.example.booklist.insert.InsertService;

@Controller
public class BookSelect {
	
	@Autowired
    InsertService service;
    /**
     * 本情報の取得
     * @param model
     * @return
     */
    @GetMapping("/book-list")
    public String bookList(Model model) {
		
        // serviceを使って、本の一覧をDBから取得する
        List<Book> bookList = service.findAll();
        // modelに本の一覧を設定して、画面に渡す
        model.addAttribute("bookList", bookList);
        // bookList.htmlの表示
        return "bookList";
    }

}
