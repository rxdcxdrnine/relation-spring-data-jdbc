package com.example.demo;

import com.example.demo.author.Author;
import com.example.demo.author.AuthorRepository;
import com.example.demo.book.AuthorRef;
import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJdbcTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ManyToManyTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @Rollback(false)
    public void testRelationShips() {
        Author author = new Author("Martin Fowler");
        authorRepository.save(author);

        Book book = new Book("Refactoring");
        book.addAuthorRef(author);
        bookRepository.save(book);

        List<Book> findBooks = bookRepository.findAll();
        for (Book findBook : findBooks) {
            System.out.println(authorRepository.findAllById(findBook.getAuthorIds()));
        }

        List<Author> findAuthors = authorRepository.findAll();
        for (Author findAuthor : findAuthors) {
            System.out.println(bookRepository.findByAuthorId(findAuthor.getId()));
        }

        // many-to-many 연관관계 매핑
        Map<Integer, Author> authorMap = findAuthors.stream()
            .collect(Collectors.toMap(Author::getId, Function.identity()));

        for (Book findBook: findBooks) {
            List<Author> authors = findBook.getAuthorRefs().stream()
                .map(AuthorRef::getAuthorId)
                .map(authorMap::get)
                .collect(Collectors.toList());
            findBook.setAuthors(authors);
        }
        System.out.println(findBooks);
    }

}
