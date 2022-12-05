package com.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierDto {
    private Integer supplier_id;
    private String supplier_name;
    private String supplier_address;
    private String supplier_contact;
    private String contact_person;
    private String note;
}
