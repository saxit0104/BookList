package com.example.booklist.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.booklist.BookRepository;

@Service
@Transactional
public class DeleteService {

	@Autowired
	BookRepository repository;
	
    public void delete(Integer id) {
    	
    	repository.deleteById(id);
    }
}
