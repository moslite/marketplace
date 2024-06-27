package com.example.marketplace.web.v1.models.outputs.get_orders;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOutput {

    private String id;
    private String name;
    private BigDecimal amount;
    private BigDecimal price;

}
