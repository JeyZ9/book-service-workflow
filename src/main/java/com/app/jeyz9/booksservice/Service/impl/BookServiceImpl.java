package com.app.jeyz9.booksservice.Service.impl;

import com.app.jeyz9.booksservice.Service.BookService;
import com.app.jeyz9.booksservice.models.Book;
import com.app.jeyz9.booksservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    
    private final BookRepository bookRepository;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    } 
    
    @Override
    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found by id: " + id));
    }
    
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    
    @Override
    public void editBook(Long id, Book newBook){
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found by id: " + id));
        book.setTitle(newBook.getTitle());
        book.setType(newBook.getType());
        book.setImg(newBook.getImg());
        bookRepository.save(book);
    }
    
    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found by id: " + id));
        bookRepository.delete(book);
    }
    
}