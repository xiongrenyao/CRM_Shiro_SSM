package com.dao;

import com.pojo.EmpRole;

import java.util.List;

public interface EmpRoleDao {
    List<EmpRole> selectAllEmpRole();

    void updateEmpRole(EmpRole empRole);

    EmpRole selectByEmpId(Integer id);

    void insertEmpRole(EmpRole empRole);

    void deleteEmpRole(Integer empId);
}
