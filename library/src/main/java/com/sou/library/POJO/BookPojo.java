package com.sou.library.POJO;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BookPojo {

    @NotBlank(message="{isbn.notblank}")
    private String isbn;

   // private int id;

    @NotBlank(message="{title.notblank}")
    private String title;

    @NotBlank(message="{author.notblank}")
    private String author;

    @NotNull(message="{publicationYear.notnull}")
    private int publicationYear ;

    @Positive(message="{edition.positive}")
    private int edition;

    @Positive(message="{price.positive}")
    private double price;

    @NotBlank(message="{category.notblank}")
    private String category;

    public BookPojo(String title, String author, int publicationYear, int edition, double price, String category, String isbn) {
       // this.id = generateIdFromIsbn(isbn);
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.edition = edition;
        this.price = price;
        this.category = category;
        this.isbn = isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getEdition() {
        return edition;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "BookPojo{" +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", edition=" + edition +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }
}
