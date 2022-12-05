package com.pos.controller;

import com.pos.dto.SupplierDto;
import com.pos.entity.Supplier;
import com.pos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/addSupplier")
    public ResponseEntity<Boolean>addSupplier(@RequestBody SupplierDto supplierDto){
        return supplierService.addSupplier(supplierDto);
    }

    @DeleteMapping("/deleteSupplier")
    public ResponseEntity<Boolean>deleteSupplier(@PathVariable Integer supplierId){
        return supplierService.deleteSupplier(supplierId);
    }

    @PutMapping("/updateSupplier")
    public ResponseEntity<Boolean>updateSupplier(@RequestBody SupplierDto supplierDto){
        return supplierService.updateSupplier(supplierDto);
    }

    @GetMapping("/getAllSupplier")
    public ResponseEntity<List<SupplierDto>>getAllSupplier(){
        return supplierService.getAllSupplier();
    }

    @GetMapping("/searchSupplier/{supplierName}")
    public ResponseEntity<SupplierDto>searchSupplier(@PathVariable String supplierName){
        return supplierService.searchSupplier(supplierName);
    }


}
