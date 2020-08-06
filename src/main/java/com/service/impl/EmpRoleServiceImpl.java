package com.service.impl;

import com.dao.EmpRoleDao;
import com.pojo.EmpRole;
import com.service.EmpRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("empRoleService")
public class EmpRoleServiceImpl implements EmpRoleService {

    @Resource
    private EmpRoleDao empRoleDao;

    @Override
    public List<EmpRole> findAllEmpRole() {
        return empRoleDao.selectAllEmpRole();
    }

    @Override
    public void modifyEmpRole(EmpRole empRole) {
        empRoleDao.updateEmpRole(empRole);
    }

    @Override
    public EmpRole findByEmpId(Integer id) {
        return empRoleDao.selectByEmpId(id);
    }

    @Override
    public void addEmpRole(Integer empId, List<EmpRole> list) {
        empRoleDao.deleteEmpRole(empId);
        for (EmpRole empRole : list) {
            empRoleDao.insertEmpRole(empRole);
        }
    }

    @Override
    public void removeEmpRole(Integer empId) {
        empRoleDao.deleteEmpRole(empId);
    }


}
