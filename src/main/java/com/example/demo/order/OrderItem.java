package com.example.demo.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Getter
@RequiredArgsConstructor
@ToString
public class OrderItem {

    @Id
    private Integer orderId;
    private final int quantity;
    private final String product;

    public OrderItem(Integer orderId, int quantity, String product) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.product = product;
    }

//    순환참조 발생
//    @Column("order_id")
//    private Order order;

    @Transient
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

}
