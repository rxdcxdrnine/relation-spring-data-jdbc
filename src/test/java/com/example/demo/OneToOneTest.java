package com.example.demo;

import com.example.demo.movie.Movie;
import com.example.demo.movie.MovieRepository;
import com.example.demo.movie.Rental;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OneToOneTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Rollback(false)
    public void testRelationShips() {
        Rental rental = new Rental(Duration.ofDays(1), 2);
        Movie movie = new Movie("Matrix", "...");
        movie.setRental(rental);
        movieRepository.save(movie);

        List<Movie> findMovies = movieRepository.findAll();
        System.out.println(findMovies);
    }
}
