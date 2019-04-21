package com.backend.api.backendapi.model;

import com.backend.api.backendapi.enumaration.UserType;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "ledger")
public class LedgerModel extends Ledger {
    @Id
    private String id;
    private String owner;
    @DBRef
    private FarmerModel farmerModel;
    @DBRef
    private OrderModel orderModel;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModified;

}
