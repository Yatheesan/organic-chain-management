package com.backend.api.backendapi.repository;

import com.backend.api.backendapi.model.LedgerModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LedgerRepository extends MongoRepository<LedgerModel, ObjectId> {
}
