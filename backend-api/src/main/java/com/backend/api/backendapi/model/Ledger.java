package com.backend.api.backendapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ledger {

    private String uniqueId;

    private String userType;

    private String type;

    private String cropType;

    private String organization;

    private String userId;

    private String name;

    private String quantity;

    private String orderId;

    private String bucketId;

    private boolean isPacked;

    private boolean isPurchased;

}
