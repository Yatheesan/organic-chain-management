package com.backend.api.backendapi.controller;

import com.backend.api.backendapi.model.OrderModel;
import com.backend.api.backendapi.services.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderManagementController {

    private final OrderManagementService orderManagementService;

    @Autowired
    public OrderManagementController(OrderManagementService orderManagementService){
        this.orderManagementService = orderManagementService;
    }

    @PostMapping()
    @RequestMapping("/api/order/add")
    public ResponseEntity<String> addOrder(@RequestBody OrderModel orderModel) {
        try {
            this.orderManagementService.addOrder(orderModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    @RequestMapping("/api/order/get/all")
    public ResponseEntity<List<OrderModel>> getOrder() {
        try {
            List<OrderModel> orderModels =  this.orderManagementService.getAllOrder();
            return new ResponseEntity<>(orderModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    @RequestMapping("/api/order/get")
    public ResponseEntity<OrderModel> getOrderById(@RequestParam("id") String id) {
        try {
            OrderModel orderModels =  this.orderManagementService.getOrder(id);
            return new ResponseEntity<>(orderModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
