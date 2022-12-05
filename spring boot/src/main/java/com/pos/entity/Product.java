package com.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Integer product_id;
    private Integer product_code;
    private String gen_name;
    private String product_name;
    private Double cost;
    private Double a_price;
    private Double price;
    private Double profit;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "supplier_id",
            referencedColumnName = "supplier_id"
    )
    private Supplier supplier;
    private Integer onHand_qty;
    private Integer qty;
    private Integer qty_sold;
    private String expiry_date;
    private String date_arrival;
}
