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

    public Order(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    @MappedCollection(idColumn = "order_id")
    private Set<OrderItem> items = new HashSet<>();

    // Spring Data JDBC 의 프로퍼티 접근 시 사용
    private void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }
}
