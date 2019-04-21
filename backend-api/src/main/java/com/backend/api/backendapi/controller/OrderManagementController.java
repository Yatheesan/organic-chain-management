package com.backend.api.backendapi.controller;

import com.backend.api.backendapi.model.OrderModel;
import com.backend.api.backendapi.model.ResponseModel;
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
    public ResponseEntity<ResponseModel> addOrder(@RequestBody OrderModel orderModel) {
        ResponseModel responseModel = new ResponseModel();
        try {
            boolean isSuccess = this.orderManagementService.addOrder(orderModel);
            if (isSuccess){
                responseModel.setMessage("Success");
                responseModel.setSuccess(true);
                responseModel.setData(null);
                return new ResponseEntity<>(responseModel, HttpStatus.OK);
            } else {
                responseModel.setMessage("fail");
                responseModel.setSuccess(false);
                responseModel.setData(null);
                return new ResponseEntity<>(responseModel, HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    @RequestMapping("/api/order/get/all")
    public ResponseEntity<ResponseModel> getOrder() {
        ResponseModel responseModel = new ResponseModel();
        try {
            List<OrderModel> orderModels =  this.orderManagementService.getAllOrder();
            responseModel.setMessage("Success");
            responseModel.setSuccess(true);
            responseModel.setData(orderModels);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            responseModel.setMessage("fail");
            responseModel.setSuccess(false);
            responseModel.setData(null);
            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
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

    @PostMapping()
    @RequestMapping("/api/order/accept")
    public ResponseEntity<String > acceptOrder(@RequestParam("ledgerId") String ledgerId, @RequestParam("farmerId") String farmerId,@RequestParam("orderId") String orderId) {
        try {
            this.orderManagementService.acceptOrder(ledgerId, farmerId, orderId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
