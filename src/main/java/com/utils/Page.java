package com.utils;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Page {
    private Integer currentPage;
    private Integer pageSize;
    private Integer startPage;
    private Integer maxPage;
    private Integer count;

    private Integer parm;

}
