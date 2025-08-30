package com.learn.bookReview.Repository;

import com.learn.bookReview.Entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<ReviewEntity, Long> {
}
