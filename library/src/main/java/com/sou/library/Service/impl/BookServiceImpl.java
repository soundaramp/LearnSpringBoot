package com.sou.library.Service.impl;

import com.sou.library.Entity.BookEntity;
import com.sou.library.Exception.BookException;
import com.sou.library.Exception.BookNotFoundException;
import com.sou.library.POJO.BookPojo;
import com.sou.library.Repository.BookRepository;
import com.sou.library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    private BookEntity convertToEntity(BookPojo bookPojo) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookPojo.getTitle());
        bookEntity.setAuthor(bookPojo.getAuthor());
        bookEntity.setPublicationYear(bookPojo.getPublicationYear());
        bookEntity.setCategory(bookPojo.getCategory());
        bookEntity.setEdition(bookPojo.getEdition());
        bookEntity.setPrice(bookPojo.getPrice());
        bookEntity.setIsbn(bookPojo.getIsbn());
        return bookEntity;
    }

    @Override
    public BookEntity addBook(BookPojo bookPojo) {
        BookEntity bookEntity = convertToEntity(bookPojo);
        if (bookRepository.findByIsbn(bookPojo.getIsbn())!=null) {
            throw new BookException("AddBook failed! Book with Isbn " + bookPojo.getIsbn() + " already exists.");
        }
        bookEntity.setAvailability(true);
        bookEntity.setReturnDate(null);
        //System.out.println("addBook:"+bookEntity);
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> addBooks(List<BookPojo> bookPojoList) {
        List<BookEntity> bookEntityList=new ArrayList<>();
        for (BookPojo bookPojo:bookPojoList) {
            BookEntity bookEntity = convertToEntity(bookPojo);
            if (bookRepository.findByIsbn(bookPojo.getIsbn())!=null) {
                throw new BookException("AddBook failed! Book with Isbn " + bookPojo.getIsbn() + " already exists.");
            }
            bookEntity.setAvailability(true);
            bookEntity.setReturnDate(null);
            bookEntityList.add(bookEntity);
        }

        //System.out.println("addBook:"+bookEntity);
        if (bookEntityList.isEmpty())
            throw new BookException("addBooks failed.");
        return bookRepository.saveAll(bookEntityList);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getBookById(int id) {
        Optional<BookEntity> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public BookEntity updateBook(int id, BookPojo bookPojo) {
        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookEntity bookEntity = optionalBook.get();
            bookEntity.setTitle(bookPojo.getTitle());
            bookEntity.setAuthor(bookPojo.getAuthor());
            bookEntity.setPublicationYear(bookPojo.getPublicationYear());
            bookEntity.setCategory(bookPojo.getCategory());
            bookEntity.setEdition(bookPojo.getEdition());
            bookEntity.setPrice(bookPojo.getPrice());
            bookEntity.setIsbn(bookPojo.getIsbn());
            return bookRepository.save(bookEntity);
        }
        return null;
    }

    @Override
    public void deleteBook(int id) {
        if (bookRepository.existsById(id))
            bookRepository.deleteById(id);
        throw new BookNotFoundException("Book with ID " + id + " not found.");
    }

    @Override
    public BookEntity lendBook(String title) {
        Optional<BookEntity> optionalBook = Optional.ofNullable(bookRepository.findByTitle(title));
        if (optionalBook.isPresent()) {
            BookEntity book = optionalBook.get();
            if (!book.isAvailability()) {
                throw new BookException("LendBook failed! Book with title " + title + " is not available.");
            }
            book.setIssuedDate(new Date());
            book.setAvailability(false);
            book.setReturnDate(null);
            return bookRepository.save(book);
        }
         throw new BookNotFoundException("Book with title " + title + " not found.");
    }

    @Override
    public BookEntity lendBook(int id) {
        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookEntity book = optionalBook.get();
            if (!book.isAvailability()) {
                throw new BookException("LendBook failed! Book with id " + id + " is not available.");
            }
            book.setIssuedDate(new Date());
            book.setAvailability(false);
            book.setReturnDate(null);
            return bookRepository.save(book);
        }
        throw new BookNotFoundException("Book with id " + id + " not found.");
    }


    @Override
    public BookEntity returnBook(String isbn) {
        Optional<BookEntity> optionalBook = Optional.ofNullable(bookRepository.findByIsbn(isbn));
        if (optionalBook.isPresent()) {
            BookEntity book = optionalBook.get();
            if (book.isAvailability()) {
                throw new BookException("ReturnBook failed, Book with isbn" +isbn+"is not lended");
            }
            book.setAvailability(true);
            book.setReturnDate(new Date());
            return bookRepository.save(book);
        }
        throw new BookException("ReturnBook failed! Book with isbn " + isbn + " not found.");
    }
}