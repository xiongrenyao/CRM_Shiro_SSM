package com.service;

import com.pojo.EmpRole;

import java.util.List;

public interface EmpRoleService {
    List<EmpRole> findAllEmpRole();

    void modifyEmpRole(EmpRole empRole);

    EmpRole findByEmpId(Integer id);

    void addEmpRole(Integer empId, List<EmpRole> list);

    void removeEmpRole(Integer empId);
}

