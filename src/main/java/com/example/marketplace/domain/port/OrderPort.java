package com.example.marketplace.domain.port;

import com.example.marketplace.domain.entity.Order;

import java.util.Optional;

public interface OrderPort {
    Optional<Order> findById(String id);
    Optional<Order> save(Order order);
}
