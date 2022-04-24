package com.example.demo.book;

import com.example.demo.author.Author;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@RequiredArgsConstructor
@ToString
public class Book {

    @Id
    @Column("book_id")
    private Integer id;
    private final String title;

    @MappedCollection(idColumn = "book_id")
    private Set<AuthorRef> authors = new HashSet<>();

    public void setAuthors(Set<AuthorRef> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        authors.add(new AuthorRef(author.getId()));
    }

    public List<Integer> getAuthorIds() {
        return authors.stream()
            .map(AuthorRef::getAuthorId)
            .collect(Collectors.toList());
    }
}
