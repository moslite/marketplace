package com.example.marketplace.web.v1.model.outputs.get_orders;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetOrderOutput {

    private String id;
    private List<ProductOutput> products;
    private CustomerOutput customer;
    private LocalDateTime dateTime;

}
