package com.service.impl;

import com.dao.CusDao;
import com.pojo.Customer;
import com.service.CusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("cusService")
public class CusServiceImpl implements CusService {

    @Resource
    private CusDao cusDao;

    @Override
    public int addCus(Customer customer) {
        return cusDao.insertCus(customer);
    }

//    @Override
//    public List<Customer> findAllCus() {
//        return cusDao.selectAllCus();
//    }

    @Override
    public void removeCus(Integer id) {
        cusDao.deleteCus(id);
    }

    @Override
    public void modifyCus(Customer customer) {
        cusDao.updateCus(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return cusDao.selectById(id);
    }

    @Override
    public Customer findByName(String name) {
        return cusDao.selectByName(name);
    }


    @Override
    public List<Customer> findByPage(Integer first, Integer maxResult) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("first", first);
        map.put("maxResult", maxResult);
        return cusDao.selectByPage(map);
    }


    @Override
    public Integer countAll() {
        return cusDao.countAll();
    }


//    @Override
//    public List<Customer> findByEmpId(Integer id) {
//        return cusDao.selectByEmpId(id);
//    }
}
