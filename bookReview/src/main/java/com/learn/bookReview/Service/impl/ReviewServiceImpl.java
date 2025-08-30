package com.learn.bookReview.Service.impl;

import com.learn.bookReview.Entity.BookEntity;
import com.learn.bookReview.Entity.ReviewEntity;
import com.learn.bookReview.POJO.BookReviewPojo;
import com.learn.bookReview.POJO.ReviewPojo;
import com.learn.bookReview.Repository.BookRepo;
import com.learn.bookReview.Repository.ReviewRepo;
import com.learn.bookReview.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    BookRepo bookRepo;

    private ReviewEntity convertToReviewEntity(ReviewPojo reviewPojo) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setReviewerName(reviewPojo.getReviewerName());
        reviewEntity.setComment(reviewPojo.getComment());
        reviewEntity.setRating(reviewPojo.getRating());
        return reviewEntity;
    }

    public List<BookReviewPojo> convertToBookReviewPojo(List<ReviewEntity> reviewEntityList) {
        List<BookReviewPojo> bookReviewPojoList = new ArrayList<>();
        for (ReviewEntity reviewEntity: reviewEntityList) {

            BookReviewPojo bookReviewPojo = new BookReviewPojo();
            bookReviewPojo.setTitle(reviewEntity.getBookEntity().getTitle());
            bookReviewPojo.setReviewerName(reviewEntity.getReviewerName());
            bookReviewPojo.setComment(reviewEntity.getComment());
            bookReviewPojo.setRating(reviewEntity.getRating());
            bookReviewPojo.setReviewId(reviewEntity.getId());
            bookReviewPojo.setAuthor(reviewEntity.getBookEntity().getAuthor());
            bookReviewPojo.setPublishedDate(reviewEntity.getBookEntity().getPublishedDate());
            bookReviewPojo.setGenre(reviewEntity.getBookEntity().getGenre());
            bookReviewPojo.setBookId(reviewEntity.getBookEntity().getId());
            bookReviewPojoList.add(bookReviewPojo);
        }
        return bookReviewPojoList;
    }

    public ReviewEntity addReview(ReviewPojo reviewPojo) {
        BookEntity bookEntity = bookRepo.findById(reviewPojo.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        ReviewEntity reviewEntity =convertToReviewEntity(reviewPojo);
        reviewEntity.setBookEntity(bookEntity);
        return reviewRepo.save(reviewEntity);
    }

    public List<BookReviewPojo> getAllReviews() {
        List<ReviewEntity> reviewEntityList = reviewRepo.findAll();
        return convertToBookReviewPojo(reviewEntityList);
    }
}
