package com.example.marketplace.domain.usecase;

import com.example.marketplace.domain.entity.Order;

import java.util.Optional;

public interface CreateOrderUseCase {
    Optional<Order> execute(Order order);
}
