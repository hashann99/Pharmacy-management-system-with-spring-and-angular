package com.pos.service.impl;

import com.pos.dto.ProductDto;
import com.pos.dto.SupplierDto;
import com.pos.entity.Supplier;
import com.pos.exception.NotFoundException;
import com.pos.repo.SupplierRepo;
import com.pos.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Boolean> addSupplier(SupplierDto supplierDto) {
        if(supplierDto.getSupplier_name().trim().isEmpty())
            throw new NullPointerException("Supplier Id Shouldn't be Empty");
        try{
            Supplier supplier=modelMapper.map(supplierDto, Supplier.class);
            Supplier sup = supplierRepo.save(supplier);
            if(sup.getSupplier_id() !=null)
                return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Couldn't be Added Supplier,Please Try Again");
        }
        throw new RuntimeException("Couldn't be Added Supplier,Please Try Again");
    }

    @Override
    public ResponseEntity<Boolean> deleteSupplier(Integer supplierId) {
        if(supplierId ==null)
            throw new NullPointerException("Supplier Id Shouldn't be Empty");
        try {
            supplierRepo.deleteById(supplierId);
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Couldn't be Deleted Supplier");
        }
    }

    @Override
    public ResponseEntity<Boolean> updateSupplier(SupplierDto supplierDto) {
        if(supplierDto.getSupplier_id()==null)
            throw new NullPointerException("Supplier Id is Empty, Please Provide Supper Id");
        try{
            Supplier supplier=modelMapper.map(supplierDto,Supplier.class);
            if(supplier.getSupplier_name().trim().isEmpty())
                throw new NullPointerException("Please Provide Supplier Name");
                Supplier sup = supplierRepo.save(supplier);
                if(sup.getSupplier_id() !=null)
                    return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        }catch (NullPointerException e){
            throw new NullPointerException("Please Provide Supplier Name");
        }catch (Exception e){
            throw new RuntimeException("Couldn't be update supplier, Please Try Again");
        }
        throw new RuntimeException("Couldn't be update supplier, Please Try Again");
    }

    @Override
    public ResponseEntity<List<SupplierDto>> getAllSupplier() {
        try {
            List<Supplier> supplierList = supplierRepo.findAll();
            if(supplierList.isEmpty())
                throw new NotFoundException("Supplier Not Found");
            List<SupplierDto> supplierDtoList = Arrays.asList(modelMapper.map(supplierList, SupplierDto[].class));
            return new ResponseEntity<List<SupplierDto>>(supplierDtoList,HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException("Supplier Not Found");
        }
    }

    @Override
    public ResponseEntity<SupplierDto> searchSupplier(String supplierName) {
        if (supplierName.trim().isEmpty())
            throw new NullPointerException("Please Provide Supplier Name");
        try{
            Supplier supplier = supplierRepo.searchSupplier(supplierName);
            if (supplier.getSupplier_id()==null)
                throw new NotFoundException("Supplier Not Found, Please Try Again");
            SupplierDto supplierDto= modelMapper.map(supplier, SupplierDto.class);
            return new ResponseEntity<SupplierDto>(supplierDto,HttpStatus.OK);
        }catch (NotFoundException e){
            throw new NotFoundException("Supplier Not Found , Please Try Again");
        }catch (Exception e){
            throw new RuntimeException("Couldn't be load Supplier");
        }
    }
}
