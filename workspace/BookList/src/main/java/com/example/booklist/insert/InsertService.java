package com.example.booklist.insert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.booklist.Book;
import com.example.booklist.BookRepository;

@Service
@Transactional
public class InsertService {

	@Autowired
	BookRepository repository;
	
	public List<Book> findAll() {
		return repository.findAll();
	}
	
	public void insert(BookForm bookForm) {
		Book book = new Book();
		
		book.setTitle(bookForm.getTitle());
		book.setPrice(bookForm.getPrice());
		book.setAuthor(bookForm.getAuthor());
		
		repository.save(book);
	}
}
