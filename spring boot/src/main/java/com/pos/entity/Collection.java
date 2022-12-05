package com.pos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Collection {
    @Id
    private Integer transaction_id;
    private String date;
    private String name;
    private String invoice;
    private Double amount;
    private String remarks;
    private Double balance;
}
