package com.example.demo.book;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();

    @Query("select b.* from book b join book_author ba on b.book_id = ba.book_id where ba.author_id = :authorId")
    List<Book> findByAuthorId(@Param("authorId") Integer authorId);
}
