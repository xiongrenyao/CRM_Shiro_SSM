package com.service.impl;

import com.dao.EmpCusDao;
import com.pojo.EmpCus;
import com.service.EmpCusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("empCusService")
public class EmpCusServiceImpl implements EmpCusService {

    @Resource
    private EmpCusDao empCusDao;

    @Override
    public List<EmpCus> findAll() {
        return empCusDao.selectAll();
    }

    @Override
    public List<EmpCus> findByEmpId(Integer empId) {
        return empCusDao.selectByEmpId(empId);
    }

    @Override
    public void addEmpCus(EmpCus empCus) {
        empCusDao.insertEmpCus(empCus);
    }

    @Override
    public void removeEmpCus(EmpCus empCus) {
        empCusDao.deleteEmpCus(empCus);
    }

    @Override
    public void modify(EmpCus empCus) {
        empCusDao.update(empCus);
    }

}
