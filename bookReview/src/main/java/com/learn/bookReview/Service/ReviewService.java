package com.learn.bookReview.Service;

import com.learn.bookReview.Entity.ReviewEntity;
import com.learn.bookReview.POJO.BookReviewPojo;
import com.learn.bookReview.POJO.ReviewPojo;
import com.learn.bookReview.Repository.ReviewRepo;

import java.util.List;

public interface ReviewService {
    public ReviewEntity addReview(ReviewPojo reviewPojo);
    public List<BookReviewPojo> getAllReviews();

}
