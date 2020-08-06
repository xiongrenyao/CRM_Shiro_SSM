package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CusVisit {
    private Integer id;
    private Customer cus;
    private Employee emp;
    private String content;
    private String date;
}
