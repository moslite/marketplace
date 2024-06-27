package com.example.marketplace.domain.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private String id;
    private List<Product> products;
    private Customer customer;
    private LocalDateTime dateTime;

}
