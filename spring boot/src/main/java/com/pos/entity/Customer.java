package com.pos.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customer_id;
    @NotNull
    private String customer_name;
    @NotNull
    private String address;
    @NotNull
    private Integer contact;
    @NotNull
    private String membership_number;
    private String prod_name;
    private String expected_date;
    private String note;
}
