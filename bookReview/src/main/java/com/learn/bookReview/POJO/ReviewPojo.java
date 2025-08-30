package com.learn.bookReview.POJO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


//@Data // Generates getters, setters, toString, equals, hashCode
//@NoArgsConstructor // No-arg constructor
//@AllArgsConstructor // All-args constructor
public class ReviewPojo {
    // rating related fields
    @Min(1)
    @Max(5)
    private int rating;

    private String comment;

    @NotBlank(message = "ReviewerName is mandatory.")
    private String reviewerName;

    @NotNull(message = "BookId is mandatory")
    private Long bookId;


    public ReviewPojo(int rating, String comment, String reviewerName, Long bookId) {
        this.rating = rating;
        this.comment = comment;
        this.reviewerName = reviewerName;
        this.bookId = bookId;
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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "ReviewPojo{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}

