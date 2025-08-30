package com.learn.bookReview.Repository;

import com.learn.bookReview.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {
    public BookEntity findByTitleAndAuthor(String title, String author);
}
