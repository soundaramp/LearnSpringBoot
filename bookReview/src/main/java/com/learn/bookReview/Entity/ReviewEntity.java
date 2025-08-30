package com.learn.bookReview.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="reviews")
public class ReviewEntity {
    @Id
    @Column(name="review_id")
    @Min(1)
    private long id;
    @Min(1)
    @Max(5)
    private int rating;
    private String comment;
    @NotBlank(message="reviewerName can not be blank")
    private String reviewerName;

    @ManyToOne(optional = false)
    @JoinColumn(name="book_id", nullable = false)
    private BookEntity bookEntity;

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getReviewerName() {
        return reviewerName;
    }
}
