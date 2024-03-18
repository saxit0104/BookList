package com.example.booklist.select;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.booklist.Book;
import com.example.booklist.BookRepository;

@Service
@Transactional
public class listService {
	
	@Autowired
	BookRepository repository;
	
	public List<Book> findAll() {
		return repository.findAll();
	}
	


}
