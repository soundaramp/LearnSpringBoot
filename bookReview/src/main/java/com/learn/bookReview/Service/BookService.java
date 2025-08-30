package com.learn.bookReview.Service;

import com.learn.bookReview.Entity.BookEntity;
import com.learn.bookReview.POJO.BookPojo;
import com.learn.bookReview.POJO.BookReviewPojo;

import java.util.List;

public interface BookService {
    public BookEntity addBook(BookPojo bookReviewPojo) throws Exception;

}
