package com.example.marketplace.data.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class CustomerDTO {

    @DynamoDBAttribute
    private String id;

    @DynamoDBAttribute
    private String name;
}
