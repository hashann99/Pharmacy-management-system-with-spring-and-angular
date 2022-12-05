package com.pos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SalesOrder {
    @Id
    private Integer transaction_id;
    private Integer invoice;
    private String product;
    private Integer qty;
    private Double amount;
    private Double profit;
    private String product_code;
    private String gen_name;
    private String name;
    private Double price;
    private Double discount;
    private String date;
}
