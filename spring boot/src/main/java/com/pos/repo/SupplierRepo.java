package com.pos.repo;

import com.pos.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Integer> {

    @Query(value = "SELECT * FROM SUPPLIER WHERE SUPPLIER_NAME = ?1",nativeQuery = true)
    Supplier searchSupplier(String supplierName);
}
