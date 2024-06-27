package com.example.marketplace.data.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class ProductDTO {

    @DynamoDBAttribute
    private String id;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private BigDecimal amount;

    @DynamoDBAttribute
    private BigDecimal price;
}
