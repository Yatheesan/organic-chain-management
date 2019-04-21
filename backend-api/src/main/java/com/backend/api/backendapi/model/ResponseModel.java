package com.backend.api.backendapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel<T> {
    private String message;
    private boolean success;
    private T data;
}
