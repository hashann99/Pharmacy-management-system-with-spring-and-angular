package com.pos.service.impl;

import com.pos.dto.CustomerDto;
import com.pos.entity.Customer;
import com.pos.exception.NotFoundException;
import com.pos.repo.CustomerRepo;
import com.pos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Boolean> addCustomer(CustomerDto customerDto) {
        if(customerDto.getCustomer_name().trim().isEmpty() | customerDto.getAddress().trim().isEmpty())
            throw new NullPointerException("Customer Name or Customer Address Empty");
        try {
            Customer customer = modelMapper.map(customerDto, Customer.class);
            Customer cus = customerRepo.save(customer);
            if (cus.getCustomer_id() != null)
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Could not add customer");
        }
        throw new RuntimeException("Could not add customer");
    }

    @Override
    public ResponseEntity<Boolean> deleteCustomer(Integer customerId) {
        if(customerId==null)
            throw new NullPointerException("Please Provide Customer ID");
        try {
            customerRepo.deleteById(customerId);
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        }catch (Exception e){
            throw new NullPointerException("Customer couldn't be deleted");
        }
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto) {
        if(customerDto.getCustomer_id() ==null)
            throw new NullPointerException("Customer Id shouldn't be empty! ");
        try {
            Customer customer=modelMapper.map(customerDto,Customer.class);
            Customer cus = customerRepo.save(customer);
            if(cus.getCustomer_id() !=null) {
                CustomerDto cusDto = modelMapper.map(cus, CustomerDto.class);
                return new ResponseEntity<CustomerDto>(cusDto,HttpStatus.OK);
            }
        }catch (Exception e){
               throw new RuntimeException("Customer couldn't be updated");
        }
        throw new RuntimeException("Customer couldn't be updated");
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        try {
            List<Customer> all = customerRepo.findAll();
            List<CustomerDto> customerDtoList = Arrays.asList(modelMapper.map(all, CustomerDto[].class));
            if(!customerDtoList.isEmpty())
                return new ResponseEntity<List<CustomerDto>>(customerDtoList,HttpStatus.OK);
        }catch (NotFoundException e){
            throw new NotFoundException("Customer Not Found Exception");
        }catch (Exception e){
            throw new RuntimeException("Couldn't be load Customers");
        }
        throw new RuntimeException("Couldn't be load Customers");
    }

    @Override
    public ResponseEntity<CustomerDto> searchCustomer(String customerName) {
        if(customerName.trim().isEmpty())
            throw new NullPointerException("Customer Name is null, Please Provide Customer Name");
        try{
            Customer customer = customerRepo.searchCustomerName(customerName);
            CustomerDto cus = modelMapper.map(customer, CustomerDto.class);
            if(customer.getCustomer_id() !=null)
                return new ResponseEntity<CustomerDto>(cus,HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException("Customer Couldn't be find");
        }
        throw new NotFoundException("Customer Couldn't be find");
    }
}
