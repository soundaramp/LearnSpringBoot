package com.learn.bookReview.Controller;

import com.learn.bookReview.Entity.BookEntity;
import com.learn.bookReview.Entity.ReviewEntity;
import com.learn.bookReview.POJO.BookPojo;
import com.learn.bookReview.POJO.BookReviewPojo;
import com.learn.bookReview.POJO.ReviewPojo;
import com.learn.bookReview.Service.BookService;
import com.learn.bookReview.Service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/books")
public class bookReviewController {
    @Autowired
    BookService bookService;

    @Autowired
    ReviewService reviewService;

    @PostMapping("/addBook")
    public ResponseEntity<BookEntity> addBook(@Valid @RequestBody BookPojo book) throws Exception {
        BookEntity bookEntity = bookService.addBook(book);
        return new ResponseEntity<>(bookEntity, HttpStatus.OK);
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<BookReviewPojo>> getAllReviews() throws Exception {
        return new ResponseEntity<>(reviewService.getAllReviews(),HttpStatus.OK);
    }

    @PostMapping("/addReview")
    public ResponseEntity<ReviewEntity> addReview(@RequestBody ReviewPojo review) throws Exception {
        return new ResponseEntity<>(reviewService.addReview(review),HttpStatus.OK);
    }
}
