package com.example.demo.order;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAll();
}
