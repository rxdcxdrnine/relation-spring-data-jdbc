package com.example.demo;

import com.example.demo.order.Order;
import com.example.demo.order.OrderItem;
import com.example.demo.order.OrderItemRepository;
import com.example.demo.order.OrderRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ManyToOneTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Test
    public void testRelationships() {
        Order order = new Order("주소지");
        OrderItem orderItem = new OrderItem(0, "상품명");
        order.addItem(orderItem);
        orderRepository.save(order);

        List<OrderItem> orderItems = orderItemRepository.findAllWithOrder();
        System.out.println("orderItems = " + orderItems);
    }
}
