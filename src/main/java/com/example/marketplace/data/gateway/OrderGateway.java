package com.example.marketplace.data.gateway;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.util.CollectionUtils;
import com.example.marketplace.data.dto.OrderDTO;
import com.example.marketplace.data.mapper.OrderDataMapper;
import com.example.marketplace.domain.entity.Order;
import com.example.marketplace.domain.port.OrderPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrderGateway implements OrderPort {

    public static final String TABLE_NAME = "order";

    private final AmazonDynamoDB amazonDynamoDB;
    private final DynamoDBMapper dynamoDBMapper;
    private final OrderDataMapper orderDataMapper;

    public OrderGateway(AmazonDynamoDB amazonDynamoDB, OrderDataMapper orderDataMapper) {
        this.amazonDynamoDB = amazonDynamoDB;
        this.orderDataMapper = orderDataMapper;
        this.dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

    @Override
    public Optional<Order> findById(String id) {
        HashMap<String, AttributeValue> params = new HashMap<>();
        params.put(":id", new AttributeValue(id));

        QueryRequest request = new QueryRequest()
                .withTableName(TABLE_NAME)
                .withKeyConditionExpression("id = :id")
                .withExpressionAttributeValues(params);
        try {
            QueryResult queryResult = amazonDynamoDB.query(request);
            List<Map<String, AttributeValue>> values = queryResult.getItems();

            if (!CollectionUtils.isNullOrEmpty(values)) {
                OrderDTO orderDTO = dynamoDBMapper.marshallIntoObject(OrderDTO.class, values.getFirst());
                return Optional.of(orderDataMapper.orderDTOToOrder(orderDTO));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Order> save(Order order) {
        try {
            dynamoDBMapper.save(orderDataMapper.orderToOrderDTO(order));
            return Optional.of(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
