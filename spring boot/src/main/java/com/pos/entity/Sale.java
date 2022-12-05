package com.pos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sale {
    @Id
    private Integer transaction_id;
    private Integer invoice_number;
    private String cashier;
    private String date;
    private String type;
    private String amount;
    private String profit;
    private String due_date;
    private String name;
    private String balance;
}
