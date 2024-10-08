package com.example.marketplace.web.v1.mapper;

import com.example.marketplace.web.v1.model.outputs.get_orders.GetOrderOutput;
import com.example.marketplace.domain.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    GetOrderOutput orderToGetOrderResponse(Order order);
}
