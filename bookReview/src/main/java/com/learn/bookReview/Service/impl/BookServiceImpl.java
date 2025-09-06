package com.learn.bookReview.Service.impl;

import com.learn.bookReview.Entity.BookEntity;
import com.learn.bookReview.POJO.BookPojo;
import com.learn.bookReview.Repository.BookRepo;
import com.learn.bookReview.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    private BookEntity convertToBookEntity(BookPojo bookPojo) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookPojo.getTitle());
        bookEntity.setAuthor(bookPojo.getAuthor());
        bookEntity.setPublishedDate(bookPojo.getPublishedDate());
        bookEntity.setGenre(bookPojo.getGenre());
        bookEntity.setPublishedDate(new Date());
        return bookEntity;
    }

    public Optional<BookEntity> getABookWithReviews(Long bookId) {
        return bookRepo.findById(bookId);

    }

    public BookEntity addBook(BookPojo bookPojo) throws Exception {
        BookEntity bookEntity = convertToBookEntity(bookPojo);
        if (bookRepo.findByTitleAndAuthor(bookPojo.getTitle(), bookPojo.getAuthor())!=null)
            throw new Exception("addBook failed. Book with Title "+bookEntity.getTitle()+" and Author "+bookEntity.getAuthor()+" exists already.");
        return bookRepo.save(bookEntity);
    }


}
