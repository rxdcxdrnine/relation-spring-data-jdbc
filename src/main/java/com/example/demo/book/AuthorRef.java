package com.example.demo.book;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@RequiredArgsConstructor
@ToString
@Table("book_author")
public class AuthorRef {

    private final Integer authorId;

}
