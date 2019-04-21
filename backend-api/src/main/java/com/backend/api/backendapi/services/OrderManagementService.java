package com.backend.api.backendapi.services;

import com.backend.api.backendapi.model.OrderModel;
import com.backend.api.backendapi.repository.OrderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManagementService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderManagementService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(OrderModel orderModel) {

        List<OrderModel> orderModels = this.orderRepository.findAll();
        int count = orderModels.size();
        OrderModel orderModel1 = new OrderModel();
        orderModel1.setId(orderModel.getCustomerId() + count);
        orderModel1.setLedgerId(orderModel.getLedgerId());
        orderModel1.setCustomerId(orderModel.getCustomerId());
        orderModel1.setOrderedDate(orderModel.getOrderedDate());
        orderModel1.setAmount(orderModel.getAmount());
        orderModel1.setDeliveryDate(orderModel.getDeliveryDate());
        orderModel1.setAddress(orderModel.getAddress());
        this.orderRepository.save(orderModel1);
    }

    public List<OrderModel> getAllOrder() {
        return this.orderRepository.findAll();
    }

    public OrderModel getOrder(String orderId) {
        return this.orderRepository.findById(orderId);
    }

}
