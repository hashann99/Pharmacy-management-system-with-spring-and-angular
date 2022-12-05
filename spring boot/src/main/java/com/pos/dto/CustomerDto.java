package com.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer customer_id;
    private String customer_name;
    private String address;
    private Integer contact;
    private String membership_number;
    private String prod_name;
    private String expected_date;
    private String note;
}
