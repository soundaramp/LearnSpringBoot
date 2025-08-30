package com.sou.library.Service;

import com.sou.library.Entity.BookEntity;
import com.sou.library.POJO.BookPojo;

import java.util.List;

public interface BookService {
    BookEntity addBook(BookPojo bookPojo);
    List<BookEntity> addBooks(List<BookPojo> bookPojo);
    List<BookEntity> getAllBooks();
    BookEntity getBookById(int id);
    BookEntity updateBook(int id, BookPojo bookPojo);
    BookEntity lendBook(String title);
    BookEntity lendBook(int id);
    BookEntity returnBook(String isbn);
    void deleteBook(int id);
}