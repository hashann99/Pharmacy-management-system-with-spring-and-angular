package com.pos.service;

import com.pos.dto.SupplierDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierService {

    ResponseEntity<Boolean> addSupplier(SupplierDto supplierDto);

    ResponseEntity<Boolean> deleteSupplier(Integer supplierId);


    ResponseEntity<Boolean> updateSupplier(SupplierDto supplierDto);

    ResponseEntity<List<SupplierDto>> getAllSupplier();

    ResponseEntity<SupplierDto> searchSupplier(String supplierName);
}
