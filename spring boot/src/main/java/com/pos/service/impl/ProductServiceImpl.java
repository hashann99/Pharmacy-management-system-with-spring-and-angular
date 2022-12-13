package com.pos.service.impl;

import com.pos.dto.CustomerDto;
import com.pos.dto.ProductDto;
import com.pos.entity.Product;
import com.pos.entity.Supplier;
import com.pos.exception.NotFoundException;
import com.pos.repo.ProductRepo;
import com.pos.repo.SupplierRepo;
import com.pos.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Boolean> addProduct(ProductDto productDto) {
        if(productDto.getProduct_name().isEmpty())
            throw new NullPointerException("Product name should not empty!");
        try{
            Product product = modelMapper.map(productDto, Product.class);
            Product pro = productRepo.save(product);
            if(pro.getProduct_id() !=null){
                return new ResponseEntity<Boolean>(true,HttpStatus.OK);
            }
        }catch (Exception e){
            throw new RuntimeException("Couldn't be Save, Please try again");
        }
        throw new RuntimeException("Couldn't be Save, Please try again");
    }

    @Override
    public ResponseEntity<Boolean> deleteProduct(Integer productId) {
        if(productId ==null)
            throw new NullPointerException("Product Id Shouldn't Empty");
        try {
            productRepo.deleteById(productId);
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Couldn't be Delete,Please Try Again");
        }

    }

    @Override
    public ResponseEntity<Boolean> updateProduct(ProductDto productDto) {
        if(productDto.getProduct_id() ==null)
            throw new NullPointerException("Product Id Empty, Please Provide Product ID");
        try {
            Product product = modelMapper.map(productDto, Product.class);
            Product pro = productRepo.save(product);
            if(pro.getProduct_id() !=null)
                return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Couldn't Be Update Product, Please Try Again");
        }
        throw new RuntimeException("Couldn't Be Update Product, Please Try Again");
    }

    @Override
    public ResponseEntity<ProductDto> searchProduct(String productName) {
        if(productName.trim().isEmpty())
            throw new NullPointerException("Product Name Shouldn't be Empty");
        try {
            Product product = productRepo.searchProduct(productName);
            if(product.getProduct_id()==null)
                throw new NotFoundException("Product Not Found");
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            return new ResponseEntity<ProductDto>(productDto,HttpStatus.OK);
        }catch (NotFoundException e){
            throw new NotFoundException("Product Not Found");
        }catch (Exception e){
            throw new RuntimeException("Product Not Found");
        }
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        try {
            List<Product> all = productRepo.findAll();
            if(all.isEmpty())
                throw new NotFoundException("Product Not Found");
            List<ProductDto> productDtoList = Arrays.asList(modelMapper.map(all, ProductDto[].class));
            return new ResponseEntity<List<ProductDto>>(productDtoList,HttpStatus.OK);
        }catch (NotFoundException e){
            throw new NotFoundException("Product Not Found");
        }catch (Exception e){
            throw new RuntimeException("Product Not Found");
        }
    }


    @Transactional
    @Override
    public List<Object> selectProductWithSupplier(Integer productId) {
        List<Object>list=new ArrayList<>();
        Optional<Product> product = productRepo.findById(productId);
        if (product.isPresent()){
            Integer supplierId = product.map(Product::getSupplier_id).get();
            Optional<Supplier> supplier = supplierRepo.findById(supplierId);
            if(supplier.isPresent()) {
                String name = supplier.map(obj -> obj.getSupplier_name()).get();
            }
        }
        list.add(new Product());
        return list;

    }


}
