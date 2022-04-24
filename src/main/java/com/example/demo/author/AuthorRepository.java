package com.example.demo.author;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    List<Author> findAll();
}
