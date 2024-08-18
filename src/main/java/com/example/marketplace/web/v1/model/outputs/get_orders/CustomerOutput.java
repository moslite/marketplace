package com.example.marketplace.web.v1.model.outputs.get_orders;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOutput {

    private String id;
    private String name;
}
