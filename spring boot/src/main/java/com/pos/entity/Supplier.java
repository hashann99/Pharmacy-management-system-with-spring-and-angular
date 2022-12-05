package com.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Supplier {

    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_sequence"
    )
    private Integer supplier_id;
    private String supplier_name;
    private String supplier_address;
    private String supplier_contact;
    private String contact_person;
    private String note;
}
