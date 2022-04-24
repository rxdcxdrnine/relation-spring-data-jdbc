package com.example.demo.order;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

    List<OrderItem> findAll();

    @Query(value = "select oi.*, o.* from order_item oi left outer join `order` o on oi.order_id = o.order_id",
    rowMapperClass = OrderItemRowMapper.class)
    List<OrderItem> findAllWithOrder();
}
