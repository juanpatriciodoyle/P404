package com.iv.p404.repository;

import com.iv.p404.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "SELECT book FROM Book book where book.id = ?1 and book.quantity >= 1")
    Optional<Book> getAvailableBookById(Integer id);

    Optional<Book> getBookById(Integer id);


    @Query(value = "SELECT book FROM Book book where book.quantity <= book.minimumStock")
    List<Book> getBooksInMinimumStock();

    @Query(value = "UPDATE Book SET quality = quality-1 where quality > 0 and bookType = ?1")
    void degrade(Integer bookType);

    @Query(value = "DELETE FROM Book book where book.quality <= 0")
    void deleteOldBooks();

    @Query(value = "UPDATE Book SET quality = quality+1 where quality > 0 and bookType = ?1")
    void enhance(Integer bookType);

}
