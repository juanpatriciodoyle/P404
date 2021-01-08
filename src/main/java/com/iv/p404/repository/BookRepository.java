package com.iv.p404.repository;

import com.iv.p404.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "SELECT book FROM Book book where book.id = ?1 and book.quantity >= 1")
    Optional<Book> getAvailableBookById(Integer id);
    Optional<Book> getBookById(Integer id);
    @Query(value = "UPDATE Book SET quality = ?2 where quality > 0 and bookType = ?1")
    Optional<Book> degrade(Integer bookType, Integer degradeValue);
    @Query(value = "DELETE FROM Book book where book.quality <= 0")
    Optional<Book> deleteOldBooks();

}
