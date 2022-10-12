package com.example.OrderService.Repository;

import com.example.OrderService.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {
    //String placeOrder(Order order);
}