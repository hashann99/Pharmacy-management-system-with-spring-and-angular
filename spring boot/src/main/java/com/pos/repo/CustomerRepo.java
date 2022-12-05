package com.pos.repo;

import com.pos.dto.CustomerDto;
import com.pos.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT * FROM CUSTOMER WHERE CUSTOMER_NAME=?1",nativeQuery = true)
    Customer searchCustomerName(String customerName);
}
