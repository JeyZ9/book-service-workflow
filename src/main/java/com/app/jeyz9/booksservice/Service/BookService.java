package com.app.jeyz9.booksservice.Service;

import com.app.jeyz9.booksservice.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void addBook(Book book);
    void editBook(Long id, Book book);
    void deleteBook(Long id);
}
