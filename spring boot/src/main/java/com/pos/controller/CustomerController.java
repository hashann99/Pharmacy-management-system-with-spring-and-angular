package com.pos.controller;

import com.pos.dto.CustomerDto;
import com.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Boolean>addCustomer(@RequestBody CustomerDto customerDto){
        return customerService.addCustomer(customerDto);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Boolean>deleteCustomer(@PathVariable Integer customerId){
        return customerService.deleteCustomer(customerId);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<CustomerDto>updateCustomer(@RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(customerDto);
    }

    @GetMapping("/searchCustomer/{customerName}")
    public ResponseEntity<CustomerDto>searchCustomer(@PathVariable String customerName){
        return customerService.searchCustomer(customerName);
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<CustomerDto>>getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
