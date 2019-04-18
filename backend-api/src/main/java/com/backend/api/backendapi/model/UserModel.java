package com.backend.api.backendapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user")
public class UserModel {

    @Id
    private String userName;
    private String email;
    private String contactNo;
    private String lastName;
    private String firstName;
    private String password;
    private String role;


}
