package com.backend.api.backendapi.repository;

import com.backend.api.backendapi.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserModel,String> {

    List<UserModel> findTopByUserNameAndPassword(String userName, String password);
}