package com.learn.bookReview.Service;

import com.learn.bookReview.Entity.BookEntity;
import com.learn.bookReview.POJO.BookPojo;

import java.util.Optional;

public interface BookService {
    public BookEntity addBook(BookPojo bookReviewPojo) throws Exception;
    public Optional<BookEntity> getABookWithReviews(Long bookId);
}
