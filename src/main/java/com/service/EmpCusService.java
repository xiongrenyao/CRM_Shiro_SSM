package com.service;

import com.pojo.EmpCus;

import java.util.List;

public interface EmpCusService {
    List<EmpCus> findAll();

    List<EmpCus> findByEmpId(Integer empId);

    void addEmpCus(EmpCus empCus);

    void removeEmpCus(EmpCus empCus);

    void modify(EmpCus empCus);
}
