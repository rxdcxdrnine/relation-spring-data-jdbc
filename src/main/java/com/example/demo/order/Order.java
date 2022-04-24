package com.example.demo.order;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@RequiredArgsConstructor
@ToString
public class Order {

    @Id
    @Column("order_id")
    private Integer id;
    private final String address;

    @MappedCollection(idColumn = "order_id")
    private final Set<OrderItem> items = new HashSet<>();

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }
}
