package com.example.demo.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class OrderItemRowMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem orderItem = new OrderItem(
            rs.getInt("order_id"),
            rs.getInt("quantity"),
            rs.getString("product")
        );
        Order order = new Order(
            rs.getInt("order_id"),
            rs.getString("address")
        );
        orderItem.setOrder(order);

        return orderItem;
    }
}
