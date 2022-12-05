package com.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private Integer product_id;
    private Integer product_code;
    private String gen_name;
    private String product_name;
    private Double cost;
    private Double a_price;
    private Double price;
    private Double profit;
    private Integer supplier_id;
    private Integer onHand_qty;
    private Integer qty;
    private Integer qty_sold;
    private String expiry_date;
    private String date_arrival;
}
