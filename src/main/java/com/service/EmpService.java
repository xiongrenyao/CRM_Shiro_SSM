package com.service;

import com.pojo.Employee;

import java.util.List;

public interface EmpService {
    Employee findByLogin(String username);

    void addEmp(Employee employee);

    List<Employee> findAllEmp();

    List<Employee> findNoMe(Integer id);

    void removeEmp(Integer id);

    void modity(Employee employee);

    Employee findById(Integer id);
}
