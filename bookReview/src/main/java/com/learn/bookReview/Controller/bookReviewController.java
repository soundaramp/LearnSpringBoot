package com.learn.bookReview.Controller;

import com.learn.bookReview.Entity.BookEntity;
import com.learn.bookReview.Entity.ReviewEntity;
import com.learn.bookReview.POJO.BookPojo;
import com.learn.bookReview.POJO.BookReviewPojo;
import com.learn.bookReview.POJO.ReviewPojo;
import com.learn.bookReview.Service.BookService;
import com.learn.bookReview.Service.ReviewService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class bookReviewController {

    // creating a logger
    Logger logger
            = LoggerFactory.getLogger(bookReviewController.class);

    @Autowired
    BookService bookService;

    @Autowired
    ReviewService reviewService;

    @PostMapping("/addBook")
    public ResponseEntity<BookEntity> addBook(@Valid @RequestBody BookPojo book) throws Exception {
        logger.debug("addBook method called with book: {}", book);
        BookEntity bookEntity = bookService.addBook(book);
        logger.info("Book added successfully: {}", bookEntity);
        return new ResponseEntity<>(bookEntity, HttpStatus.OK);
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<BookReviewPojo>> getAllReviews() throws Exception {
        logger.debug("getAllReviews method called");
        List<BookReviewPojo> bookReviewPojoList = reviewService.getAllReviews();
        if (bookReviewPojoList.isEmpty()) {
            logger.info("No reviews found");
            return new ResponseEntity<>(bookReviewPojoList, HttpStatus.NO_CONTENT);
        }
        logger.info("bookReviewPojoList: {}", bookReviewPojoList);
        return new ResponseEntity<>(bookReviewPojoList, HttpStatus.OK);
    }

    @PostMapping("/addReview")
    public ResponseEntity<ReviewEntity> addReview(@Valid @RequestBody ReviewPojo review) throws Exception {
        logger.debug("addReview method called with review: {}", review);
        ReviewEntity reviewEntity = reviewService.addReview(review);
        logger.info("Review added successfully: {}", reviewEntity);
        return new ResponseEntity<>(reviewEntity, HttpStatus.OK);
    }



    @GetMapping("/getBookAvgRating/{bookId}")
    public ResponseEntity<Double> getBookAvgRating(@PathVariable Long bookId) throws Exception {
        logger.debug("getBookAvgRating method called with bookId: {}", bookId);
        List<BookReviewPojo> bookReviewPojos = reviewService.getAllReviews();
        double avgRating = 0.0;
        int count = 0;
        for (BookReviewPojo bookReviewPojo : bookReviewPojos) {
            if (bookReviewPojo.getBookId()==(bookId)) {
                avgRating += bookReviewPojo.getRating();
                count++;
            }
        }
        if (count == 0) {
            logger.info("No reviews found for bookId: {}", bookId);
            return new ResponseEntity<>(0.0, HttpStatus.OK);
        }
        avgRating = avgRating / count;
        logger.info("Average rating for bookId {}: {}", bookId, avgRating);
        return new ResponseEntity<>(avgRating, HttpStatus.OK);
    }

    @GetMapping("getBookreviews/{bookId}")
    public ResponseEntity<Optional<BookEntity>> getBookReviews(@PathVariable Long bookId) throws Exception {
        logger.debug("getBookReviews method called with bookId: {}", bookId);
        Optional<BookEntity> bookEntity = bookService.getABookWithReviews(bookId);
        if (bookEntity.isEmpty()) {
            logger.info("No Book found for bookId: {}", bookId);
            return new ResponseEntity<>(bookEntity, HttpStatus.NO_CONTENT);
        }
        logger.info("BookEntity for bookId {}: {}", bookId, bookEntity);
        return new ResponseEntity<>(bookEntity, HttpStatus.OK);
    }

}
