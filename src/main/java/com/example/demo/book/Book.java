package com.example.demo.book;

import com.example.demo.author.Author;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
    private Set<AuthorRef> authorRefs = new HashSet<>();

    @Transient
    private List<Author> authors = new ArrayList<>();

    // Spring Data JDBC 의 프로퍼티 접근 시 사용
    private void setAuthorRefs(Set<AuthorRef> authorRefs) {
        this.authorRefs = authorRefs;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthorRef(Author author) {
        authorRefs.add(new AuthorRef(author.getId()));
    }

    public List<Integer> getAuthorIds() {
        return authorRefs.stream()
            .map(AuthorRef::getAuthorId)
            .collect(Collectors.toList());
    }
}
