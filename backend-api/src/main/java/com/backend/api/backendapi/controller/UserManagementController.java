package com.backend.api.backendapi.controller;

import com.backend.api.backendapi.model.UserModel;
import com.backend.api.backendapi.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserManagementController {

    private final UserManagementService userManagementService;

    @Autowired
    public UserManagementController(UserManagementService userManagementService){
        this.userManagementService = userManagementService;
    }

    @PostMapping()
    @RequestMapping("/api/user/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserModel userModel){
        try {
            this.userManagementService.saveUserDetails(userModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping()
    @RequestMapping("/api/user/login")
    public ResponseEntity<UserModel> getUserDetails(@RequestParam("password") String password,
                                                    @RequestParam("userName") String userName){

        try {
            UserModel userModel = new UserModel();
            userModel.setUserName(userName);
            userModel.setPassword(password);
            if (this.userManagementService.validateUserLogin(userModel)) {
                return new ResponseEntity<>(userModel,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(userModel,HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping()
    @RequestMapping("/api/user/role")
    public ResponseEntity<List<UserModel>> getUserListBasedOnRole(@RequestParam("role") String role) {
        List<UserModel> userModels = null;
        try {
            userModels = this.userManagementService.returnListBasedOnModel(role);
            return new ResponseEntity<>(userModels,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
