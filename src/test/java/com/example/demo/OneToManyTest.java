package com.example.demo;

import com.example.demo.order.Order;
import com.example.demo.order.OrderItem;
import com.example.demo.order.OrderRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OneToManyTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testRelationShips() {
        Order order = new Order("주소지");
        OrderItem orderItem_1 = new OrderItem(0, "상품명1");
        OrderItem orderItem_2 = new OrderItem(0, "상품명2");
        order.addItem(orderItem_1);
        order.addItem(orderItem_2);
        orderRepository.save(order);

        List<Order> orders = orderRepository.findAll();
        System.out.println("orders = " + orders);
    }
}
