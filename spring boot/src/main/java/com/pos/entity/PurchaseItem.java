package com.pos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PurchaseItem {
    @Id
    private Integer id;
    private String name;
    private Integer qty;
    private String cost;
    private String invoice;
}
