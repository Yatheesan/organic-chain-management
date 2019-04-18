package com.backend.api.backendapi.enumaration;

public enum UserType {
    MANAGER("manager"),
    CUSTOMER("customer"),
    FARMER("farmer");

    private String stringValue;

    UserType(String value) {
        stringValue = value;
    }

    public String getStringValue() {
        return stringValue;
    }
}
