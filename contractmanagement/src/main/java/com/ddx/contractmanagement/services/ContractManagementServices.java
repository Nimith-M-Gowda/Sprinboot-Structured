package com.ddx.contractmanagement.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.ddx.contractmanagement.model.Contract;
import com.ddx.contractmanagement.repositories.ContractManagementRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContractManagementServices {

private final ContractManagementRepository contractManagementRepository;

public ContractManagementServices(ContractManagementRepository contractManagementRepository) {
    this.contractManagementRepository = contractManagementRepository;
}

public List<Contract> getAllContracts() {
    return contractManagementRepository.findAll();
}

public ResponseEntity<Contract> addContract(Contract contractDetails){
    this.contractManagementRepository.save(contractDetails);
    return ResponseEntity.ok().body(contractDetails);
}

public ResponseEntity<Contract> getContractById(Long contractId) throws  Exception{
        Contract contract =  this.contractManagementRepository.findById(contractId).orElseThrow(() -> new Exception("No match for Id"));
         return ResponseEntity.ok().body(contract);
}

public Contract updateContract(Long contractId, Contract contractDetails) throws Exception {
Contract contract = this.contractManagementRepository.findById(contractId).orElseThrow(() -> new Exception());
contract.setName(contractDetails.getName());
contract.setDescription(contractDetails.getDescription());
contract.setStartDate(contractDetails.getStartDate());
contract.setEndDate(contractDetails.getEndDate());
this.contractManagementRepository.save(contract);
return contract;
}

public Map<String,Boolean> deleteContract(Long Id) throws Exception{
    Contract contract = this.contractManagementRepository.findById(Id).orElseThrow(() -> new Exception());
this.contractManagementRepository.delete(contract);
    Map response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
}
}