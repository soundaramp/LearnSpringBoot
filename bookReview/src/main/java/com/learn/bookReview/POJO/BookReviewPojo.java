package com.learn.bookReview.POJO;

import com.learn.bookReview.Enums.Genre;
import jakarta.validation.constraints.*;


import java.util.Date;

//@Data

public class BookReviewPojo {
    private long bookId;
    private long reviewId;
    private String title;
    private String author;
    private Date publishedDate;
    private Genre genre;
    // rating related fields
    private int rating;
    private String comment;
    private String reviewerName;

    public BookReviewPojo() {
    }

    public BookReviewPojo(long bookId, long reviewId, String title, String author, Date publishedDate, Genre genre, int rating, String comment, String reviewerName) {
        this.bookId = bookId;
        this.reviewId = reviewId;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.rating = rating;
        this.comment = comment;
        this.reviewerName = reviewerName;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    @Override
    public String toString() {
        return "BookReviewPojo{" +
                "bookId=" + bookId +
                ", reviewId=" + reviewId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", genre=" + genre +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                '}';
    }
}
