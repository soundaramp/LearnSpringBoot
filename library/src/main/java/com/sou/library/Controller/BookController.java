package com.sou.library.Controller;

import com.sou.library.Entity.BookEntity;
import com.sou.library.Exception.BookException;
import com.sou.library.POJO.BookPojo;
import com.sou.library.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sou.library.Exception.BookNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    // Create
    @PostMapping("/addBook")
    public ResponseEntity<BookEntity> addBook(@Valid @RequestBody BookPojo bookPojo) {
        try {
            return ResponseEntity.ok(bookService.addBook(bookPojo));
        } catch (Exception e) {
            throw new BookException(e);
        }
    }


    @PostMapping("/addBooks")
    public ResponseEntity<List<BookEntity>> addBook(@Valid @RequestBody List<BookPojo> bookPojo) {
        try {
            return ResponseEntity.ok(bookService.addBooks(bookPojo));
        } catch (Exception e) {
            throw new BookException(e);
        }
    }

    // Read all
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        try {
            return ResponseEntity.ok(bookService.getAllBooks());
        } catch (Exception e) {
            throw new BookException(e);
        }
    }

    // Read by ID
    @GetMapping("/getBook/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(bookService.getBookById(id));
        } catch (Exception e) {
            throw new BookException(e);
        }
    }

    // Update
    @PutMapping("/updateBook")
    public ResponseEntity<BookEntity> updateBook(@RequestParam int id, @Valid @RequestBody BookPojo bookPojo) {
        try {
            return ResponseEntity.ok(bookService.updateBook(id, bookPojo));
        } catch (Exception e) {
            throw new BookException(e);
        }
    }

    // Delete
    @DeleteMapping("/deleteBook") //why second time, record not found error is missing
    public ResponseEntity<Void> deleteBook(@RequestParam int id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {
            throw new BookException(e);
        }
    }

    @PostMapping("/lendBook")
    public ResponseEntity<BookEntity> lendBook (@RequestParam  String  title) {
        try {
            if (title == null || title.trim().isEmpty()) {
                throw new BookException("Title parameter is missing or empty");
            }
            BookEntity bookEntity = bookService.lendBook(title);
            return ResponseEntity.ok(bookEntity);
        } catch (Exception e) {
            throw new BookException(e);
        }
    }


    @PostMapping("/lendBookById")
    public ResponseEntity<BookEntity> lendBook (@RequestParam  int  id) {
        try {
            BookEntity bookEntity = bookService.lendBook(id);
            return ResponseEntity.ok(bookEntity);
        } catch (Exception e) {
            throw new BookException(e);
        }
    }


    @PostMapping("/returnBook")
    public ResponseEntity<BookEntity> returnBook(@RequestParam  String isbn) throws BookNotFoundException, BookException {
        BookEntity bookEntity = bookService.returnBook(isbn);
        return ResponseEntity.ok(bookEntity);
    }

}