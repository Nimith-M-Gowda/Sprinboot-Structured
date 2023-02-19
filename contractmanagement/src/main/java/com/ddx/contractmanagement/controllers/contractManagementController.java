package com.ddx.contractmanagement.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import com.ddx.contractmanagement.model.Contract;
import com.ddx.contractmanagement.services.ContractManagementServices;

@RestController
@RequestMapping("/api/v1/")
public class contractManagementController {

    private final ContractManagementServices contractManagementServicesObj;

    public contractManagementController(ContractManagementServices contractManagementServicesObj){
        this.contractManagementServicesObj = contractManagementServicesObj;
    }

    @GetMapping("hello")
    public String index(){
        return "Hello World";
    }

    @GetMapping("contracts")
    public List<Contract> getAllContract(){
        return contractManagementServicesObj.getAllContracts();
    }

    @PostMapping("contracts")
    public ResponseEntity<Contract> addContract(@RequestBody Contract ContractDetails ){
        return contractManagementServicesObj.addContract(ContractDetails);
    }

    @GetMapping("contract/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable(value = "id") Long ContractId) throws Exception{
        return contractManagementServicesObj.getContractById(ContractId);
    }

    @PutMapping("contract/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable(value = "id") Long id, @RequestBody Contract contractDetails) throws Exception{
       return ResponseEntity.ok().body(contractManagementServicesObj.updateContract(id, contractDetails));
    }

    @DeleteMapping("contract/{id}")
    public Map<String,Boolean> deleteContract(@PathVariable(value="id") long contractId) throws Exception{
        return contractManagementServicesObj.deleteContract(contractId);
    }
}




