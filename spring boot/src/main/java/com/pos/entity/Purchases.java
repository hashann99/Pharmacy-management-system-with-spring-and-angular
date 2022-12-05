package com.pos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchases {
    @Id
    private Integer transaction_id;
    private Integer invoice_number;
    private String date;
    private String supplier;
    private String remarks;
}
