package com.dao;

import com.pojo.Employee;

import java.util.List;

public interface EmpDao {
    Employee selectByLogin(String username);

    void insertEmp(Employee employee);

    List<Employee> selectAllEmp();

    void deleteEmp(Integer id);

    void updateEmp(Employee employee);

    Employee selectById(Integer id);

    List<Employee> selectNoMe(Integer id);
}
