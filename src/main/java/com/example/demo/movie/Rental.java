package com.example.demo.movie;

import java.time.Duration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Rental {

    private final Duration duration;
    private final Integer price;

}
