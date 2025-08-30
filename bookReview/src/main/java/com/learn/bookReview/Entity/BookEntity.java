package com.learn.bookReview.Entity;

import com.learn.bookReview.Enums.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue
    @Column(name="book_id")
    private long id;

    private String title;
    private String author;

    @Column(name="published_date")
    private Date publishedDate;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "bookEntity", cascade = CascadeType.ALL)
    List<ReviewEntity> reviewEntityList;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public Genre getGenre() {
        return genre;
    }
}
