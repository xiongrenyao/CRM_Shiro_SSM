package com.service.impl;

import com.dao.EmpDao;
import com.pojo.Employee;
import com.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpDao empDao;

    @Override
    public Employee findByLogin(String username) {
        return empDao.selectByLogin(username);
    }

    @Override
    public void addEmp(Employee employee) {
        empDao.insertEmp(employee);
    }

    @Override
    public List<Employee> findAllEmp() {
        return empDao.selectAllEmp();
    }

    @Override
    public List<Employee> findNoMe(Integer id) {
        return empDao.selectNoMe(id);
    }

    @Override
    public void removeEmp(Integer id) {
        empDao.deleteEmp(id);
    }

    @Override
    public void modity(Employee employee) {
        empDao.updateEmp(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return empDao.selectById(id);
    }
}
