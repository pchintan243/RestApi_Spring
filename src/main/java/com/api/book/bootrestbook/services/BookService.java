package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.repositories.BookRepository;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> allBooks = (List<Book>) this.bookRepository.findAll();
        return allBooks;
    }

    public Book getBookId(int id) {
        Book book = bookRepository.findById(id);
        if (book == null) {
            return null;
        }
        return book;
    }

    public Book addBook(Book book) {
        Book newBook = bookRepository.save(book);
        return newBook;
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(int id, Book book) {
        Book getBook = bookRepository.findById(id);
        if (getBook == null) {
            return null;
        }
        book.setId(id);
        Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }
}
