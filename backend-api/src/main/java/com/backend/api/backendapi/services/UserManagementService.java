package com.backend.api.backendapi.services;

import com.backend.api.backendapi.model.UserModel;
import com.backend.api.backendapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Department Metadata Saving Service
 */
@Service
public class UserManagementService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public UserManagementService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void saveUserDetails(UserModel userModel) {
        this.userRepository.save(userModel);
    }

    public boolean validateUserLogin(UserModel userModel) {
        List<UserModel> userModels = userRepository.findTopByUserNameAndPassword(userModel.getUserName(), userModel.getPassword());
        if (userModels.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
