package com.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Perm {
    private Integer permId;
    private String permName;
    private String permUrl;
    private Integer xxId;
}
