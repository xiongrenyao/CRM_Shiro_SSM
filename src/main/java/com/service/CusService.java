package com.service;

import com.pojo.Customer;

import java.util.List;

public interface CusService {
    int addCus(Customer customer);

    //    List<Customer> findAllCus();
    void removeCus(Integer id);

    void modifyCus(Customer customer);

    Customer findById(Integer id);

    //    List<Customer> findByEmpId(Integer id);
    Customer findByName(String name);

    List<Customer> findByPage(Integer first, Integer maxResult);

    Integer countAll();


}
