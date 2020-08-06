package com.dao;

import com.pojo.Customer;

import java.util.List;
import java.util.Map;

public interface CusDao {
    int insertCus(Customer customer);

    List<Customer> selectAllCus();

    void deleteCus(Integer id);

    void updateCus(Customer customer);

    Customer selectById(Integer id);

    //    List<Customer> selectByEmpId(Integer id);
    Customer selectByName(String name);

    List<Customer> selectByPage(Map<String, Object> param);

    Integer countAll();

    List<Customer> selectByPages();
}
