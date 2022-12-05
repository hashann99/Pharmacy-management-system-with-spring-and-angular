package com.pos.repo;

import com.pos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME=?1",nativeQuery = true)
    Product searchProduct(String productName);
}
