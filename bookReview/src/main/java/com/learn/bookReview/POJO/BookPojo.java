package com.learn.bookReview.POJO;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.learn.bookReview.Enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.Date;

//@Data // Generates getters, setters, toString, equals, hashCode
//@NoArgsConstructor // No-arg constructor
//@AllArgsConstructor // All-args constructor
public class BookPojo {
    @Size(min=0, max=100)
    @NotBlank(message="Title cannot be blank")
    private String title;
    @NotBlank(message="Author cannot be blank")
    private String author;
    private Date publishedDate;
    @NotNull(message="Genre is mandatory")
    private Genre genre;

    public BookPojo(String title, String author, Date publishedDate, Genre genre) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
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

    @Override
    public String toString() {
        return "BookPojo{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", genre=" + genre +
                '}';
    }
}
