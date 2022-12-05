package com.pos.service;

import com.pos.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<Boolean> addProduct(ProductDto productDto);

    ResponseEntity<Boolean> deleteProduct(Integer productId);

    ResponseEntity<Boolean> updateProduct(ProductDto productDto);

    ResponseEntity<ProductDto> searchProduct(String productName);

    ResponseEntity<List<ProductDto>> getAllProduct();
}
