package com.example.marketplace.domain.usecase;

import com.example.marketplace.domain.entity.Order;

import java.util.Optional;

public interface GetOrderUseCase {
    Optional<Order> execute(String id);
}
