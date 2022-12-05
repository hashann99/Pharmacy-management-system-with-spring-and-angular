package com.pos.service;

import com.pos.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<Boolean> addCustomer(CustomerDto customerDto);

    ResponseEntity<Boolean> deleteCustomer(Integer customerId);

    ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto);

    ResponseEntity<List<CustomerDto>> getAllCustomer();

    ResponseEntity<CustomerDto> searchCustomer(String customerName);
}
