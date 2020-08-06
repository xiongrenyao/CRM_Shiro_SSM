package com.dao;

import com.pojo.EmpCus;

import java.util.List;

public interface EmpCusDao {
    List<EmpCus> selectAll();

    List<EmpCus> selectByEmpId(Integer id);

    void insertEmpCus(EmpCus empCus);

    void deleteEmpCus(EmpCus empCus);

    void update(EmpCus empCus);
}
