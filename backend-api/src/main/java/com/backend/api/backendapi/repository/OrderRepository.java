package com.backend.api.backendapi.repository;

import com.backend.api.backendapi.model.LedgerModel;
import com.backend.api.backendapi.model.OrderModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderModel, ObjectId> {
    OrderModel findById(String id);
}
