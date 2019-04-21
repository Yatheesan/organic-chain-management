package com.backend.api.backendapi.services;

import com.backend.api.backendapi.model.LedgerModel;
import com.backend.api.backendapi.model.OrderModel;
import com.backend.api.backendapi.model.UserModel;
import com.backend.api.backendapi.repository.LedgerRepository;
import com.backend.api.backendapi.repository.OrderRepository;
import com.backend.api.backendapi.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManagementService {
    private OrderRepository orderRepository;
    private LedgerRepository ledgerRepository;
    private UserRepository userRepository;
    @Autowired
    public OrderManagementService(UserRepository userRepository,OrderRepository orderRepository, LedgerRepository ledgerRepository) {
        this.orderRepository = orderRepository;
        this.ledgerRepository = ledgerRepository;
        this.userRepository = userRepository;
    }

    public boolean addOrder(OrderModel orderModel) {

        List<OrderModel> orderModels = this.orderRepository.findAll();
        List<UserModel> userModels = this.userRepository.findAll();
        boolean isValidUser = false;
        for (UserModel user : userModels) {
            if(user.getUserName().equalsIgnoreCase(orderModel.getFarmerId())){
                isValidUser = true;
            }
        }

        if(!isValidUser) {
            return false;
        } else {
            int count = orderModels.size();
            OrderModel orderModel1 = new OrderModel();
            orderModel1.setId(orderModel.getCustomerId() + count);
            orderModel1.setLedgerId(orderModel.getLedgerId());
            orderModel1.setCustomerId(orderModel.getCustomerId());
            orderModel1.setOrderedDate(orderModel.getOrderedDate());
            orderModel1.setAmount(orderModel.getAmount());
            orderModel1.setDeliveryDate(orderModel.getDeliveryDate());
            orderModel1.setAddress(orderModel.getAddress());
            orderModel1.setFarmerId(orderModel.getFarmerId());
            orderModel1.setAccepted(false);
            this.orderRepository.save(orderModel1);
            return true;
        }
    }

    public List<OrderModel> getAllOrder() {
        return this.orderRepository.findAll();
    }

    public OrderModel getOrder(String orderId) {
        return this.orderRepository.findById(orderId);
    }

    public void  acceptOrder(String ledgerId, String farmerId, String orderId) {

        List<OrderModel> orderModels = this.orderRepository.findAllById(orderId);
        List<LedgerModel> ledgerModels = this.ledgerRepository.findAllById(ledgerId);
        if (!orderModels.isEmpty() && !ledgerModels.isEmpty()) {
            OrderModel orderModel = orderModels.get(0);
            orderModel.setLedgerId(ledgerId);
            orderModel.setFarmerId(farmerId);
            orderModel.setAccepted(true);
        }

    }
}
