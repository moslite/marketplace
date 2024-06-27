package com.example.marketplace.domain.usecase.impl;

import com.example.marketplace.domain.entity.Order;
import com.example.marketplace.domain.port.OrderPort;
import com.example.marketplace.domain.usecase.GetOrderUseCase;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetOrderUseCaseImpl implements GetOrderUseCase {

    private final OrderPort orderPort;

    public GetOrderUseCaseImpl(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @Override
    public Optional<Order> execute(String id) {
        return orderPort.findById(id);
    }
}
