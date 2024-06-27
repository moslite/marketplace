package com.example.marketplace.web.v1.controllers;

import com.example.marketplace.web.v1.models.outputs.get_orders.GetOrderOutput;
import com.example.marketplace.domain.entity.Order;
import com.example.marketplace.domain.usecase.GetOrderUseCase;
import com.example.marketplace.web.v1.mappers.OrderMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("v1/orders")
@Tag(name = "Orders API", description = "Order management APIs")
public class OrderController {

    private final GetOrderUseCase getOrderUseCase;
    private final OrderMapper orderMapper;

    public OrderController(GetOrderUseCase getOrderUseCase, OrderMapper orderMapper) {
        this.getOrderUseCase = getOrderUseCase;
        this.orderMapper = orderMapper;
    }

    @GetMapping(value = "{id}")
    @Operation(summary = "Find your order using ID as an URI parameter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the order", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GetOrderOutput.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Order not found"),
    })
    public ResponseEntity<?> getOrder(HttpServletRequest httpServletRequest, @PathVariable(value = "id") String id) {
        Optional<Order> order = getOrderUseCase.execute(id);

        if (order.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(orderMapper.orderToGetOrderResponse(order.get()));
    }

}
