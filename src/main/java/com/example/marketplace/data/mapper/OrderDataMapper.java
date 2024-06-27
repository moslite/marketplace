package com.example.marketplace.data.mapper;

import com.example.marketplace.data.dto.OrderDTO;
import com.example.marketplace.domain.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDataMapper {
    OrderDTO orderToOrderDTO(Order order);
    Order orderDTOToOrder(OrderDTO orderDTO);
}
