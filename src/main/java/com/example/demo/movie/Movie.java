package com.example.demo.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
@ToString
public class Movie {

    @Id
    @Column("movie_id")
    private Integer id;
    private final String title;
    private final String description;

    @Column("movie_id")
    private Rental rental;

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
