package com.example.booklist.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.booklist.Book;
import com.example.booklist.BookRepository;
import com.example.booklist.insert.EditBookForm;

@Service
@Transactional
public class AddService {

	@Autowired
	BookRepository repository;
    // 本を更新する
    public void update(EditBookForm editBook) {
		
        // データベースに登録する値を保持するインスタンスの作成
        Book book = new Book();
		
        // 画面から受け取った値を設定する
        book.setId(editBook.getId());
        book.setTitle(editBook.getTitle());
        book.setPrice(editBook.getPrice());
        book.setAuthor(editBook.getAuthor());
		
        // データベースを更新する
        repository.save(book);
    }
    
	// 受け取ったidからデータを取得して、Formを返却する
    public EditBookForm getOneBook(Integer id) {
		
        // idを指定して本の情報を取得する
        Book book = repository.findById(id).orElseThrow();
		
        // 画面返却用のFormに値を設定する
        EditBookForm editBook = new EditBookForm();
        editBook.setId(book.getId());
        editBook.setTitle(book.getTitle());
        editBook.setPrice(book.getPrice());
        editBook.setAuthor(book.getAuthor());
		
        return editBook;
    }
}
