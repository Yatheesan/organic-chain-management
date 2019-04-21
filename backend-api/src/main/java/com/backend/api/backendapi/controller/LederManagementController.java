package com.backend.api.backendapi.controller;

import com.backend.api.backendapi.model.Ledger;
import com.backend.api.backendapi.model.LedgerModel;
import com.backend.api.backendapi.services.LederManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LederManagementController {

    private final LederManagementService lederManagementService;

    @Autowired
    public LederManagementController(LederManagementService lederManagementService) {
        this.lederManagementService = lederManagementService;
    }

    @PostMapping("/api/ledger/add")
    public ResponseEntity<String> addLedger(@Valid @RequestBody Ledger
                                                        ledger) {
        try {
            LedgerModel ledgerModel = new LedgerModel();
            ledgerModel.setType(ledger.getType());
            ledgerModel.setUserType(ledger.getUserType());
            ledgerModel.setCropType(ledger.getCropType());
            ledgerModel.setOrganization(ledger.getOrganization());
            ledgerModel.setUserId(ledger.getUserId());
            ledgerModel.setUniqueId(ledger.getUniqueId());
            ledgerModel.setPurchased(ledger.isPurchased());
            ledgerModel.setPacked(ledger.isPacked());
            ledgerModel.setName(ledger.getName());
            ledgerModel.setQuantity(ledger.getQuantity());
            ledgerModel.setOrderId(ledger.getOrderId());
            this.lederManagementService.addLedger(ledgerModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/ledger/get")
    public ResponseEntity<List<LedgerModel>> getLedger() {
        try {
            List<LedgerModel> ledgerModels = this.lederManagementService.getLedger();
            return new ResponseEntity<>(ledgerModels,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/ledger/user/get")
    public ResponseEntity<List<LedgerModel>> getLedgerByUserName(@RequestParam("userName") String userName) {
        try {
            List<LedgerModel> ledgerModels = this.lederManagementService.getLedgerByLedger(userName);
            return new ResponseEntity<>(ledgerModels,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
