package com.sou.library.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@Entity
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String author;
    @Column(name = "publication_year")
    private int publicationYear;
    private int edition;
    private double price;
    private String category;
    @Column(columnDefinition = "boolean default true")
    private boolean availability;
    private Date issuedDate;
    private Date returnDate;
    private String isbn;

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
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

    public boolean isAvailability() {
        return availability;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public static int generateIdFromIsbn(String isbn) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(isbn.getBytes(StandardCharsets.UTF_8));
            // Use the first 4 bytes for a 32-bit int
            return new BigInteger(hash).intValue();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
