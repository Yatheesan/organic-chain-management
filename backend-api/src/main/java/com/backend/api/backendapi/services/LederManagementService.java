package com.backend.api.backendapi.services;

import com.backend.api.backendapi.model.LedgerModel;
import com.backend.api.backendapi.model.UserModel;
import com.backend.api.backendapi.repository.LedgerRepository;
import com.backend.api.backendapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LederManagementService {

    private LedgerRepository ledgerRepository;
    private UserRepository userRepository;

    public LederManagementService(LedgerRepository ledgerRepository, UserRepository userRepository) {
        this.ledgerRepository = ledgerRepository;
        this.userRepository = userRepository;
    }

    public void addLedger(LedgerModel ledgerModel) {
        List<UserModel> userModelList = this.userRepository.findAll();
        if (userModelList.isEmpty()) {

        } else {
            for (UserModel userModel: userModelList) {
                String userId = ledgerModel.getUserId();
                ledgerModel.setId(userModel.getUserName() + "_" + userModel.getRole() + "_" + userId);
                this.ledgerRepository.save(ledgerModel);
            }
        }
    }

    public List<LedgerModel> getLedger(){
        List<LedgerModel> ledgerModels = this.ledgerRepository.findAll();
        return ledgerModels;
    }
}
