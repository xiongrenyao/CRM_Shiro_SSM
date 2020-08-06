package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private Integer cusId;
    private String cusName;
    private String address;
    private String contact;
    private String tel;
    private String email;
}
