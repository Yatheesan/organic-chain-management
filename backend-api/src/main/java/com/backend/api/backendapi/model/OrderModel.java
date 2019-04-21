package com.backend.api.backendapi.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "order")
public class OrderModel {
    @Id
    private String id;
    private String ledgerId;
    private String customerId;
    private String orderedDate;
    private String amount;
    private String deliveryDate;
    private String address;
    private boolean isAccepted;
    private String farmerId;
}
