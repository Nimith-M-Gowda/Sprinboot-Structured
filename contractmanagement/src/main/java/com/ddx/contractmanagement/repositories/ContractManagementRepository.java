package com.ddx.contractmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddx.contractmanagement.model.Contract;

@Repository
public interface ContractManagementRepository extends JpaRepository<Contract,Long>{

}