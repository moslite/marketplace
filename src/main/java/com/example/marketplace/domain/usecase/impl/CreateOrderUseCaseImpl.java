package com.example.marketplace.domain.usecase.impl;

import com.example.marketplace.domain.entity.Order;
import com.example.marketplace.domain.port.OrderPort;
import com.example.marketplace.domain.usecase.CreateOrderUseCase;

import java.util.Optional;

public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderPort orderPort;

    public CreateOrderUseCaseImpl(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @Override
    public Optional<Order> execute(Order order) {
        return Optional.empty();
    }
}
