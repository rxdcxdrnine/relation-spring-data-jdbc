package com.example.demo.author;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
@ToString
public class Author {

    @Id
    @Column("author_id")
    private Integer id;
    private final String name;

}
