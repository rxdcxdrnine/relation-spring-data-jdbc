package com.example.demo.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class OrderItem {

    private final int quantity;
    private final String product;
}
