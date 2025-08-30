package com.sou.library.Repository;

import com.sou.library.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    public BookEntity findByTitle(String title);
    public BookEntity findByIsbn(String isbn);
}

