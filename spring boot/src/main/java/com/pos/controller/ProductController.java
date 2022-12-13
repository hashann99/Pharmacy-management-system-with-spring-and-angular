package com.pos.controller;

import com.pos.dto.ProductDto;
import com.pos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Boolean>addProduct(@RequestBody ProductDto productDto){
        System.out.println(productDto.getSupplier_id());
        return productService.addProduct(productDto);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Boolean>deleteProduct(@PathVariable Integer productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Boolean>updateProduct(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }

    @GetMapping("/searchProduct/{productName}")
    public ResponseEntity<ProductDto>searchProduct(@PathVariable String productName){
        return productService.searchProduct(productName);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductDto>>getAllProduct(){
        return productService.getAllProduct();
    }


    @GetMapping("/getProduct/{id}")
    public void selectProductWithSupplier(@PathVariable Integer id){
        productService.selectProductWithSupplier(id);
    }

}
