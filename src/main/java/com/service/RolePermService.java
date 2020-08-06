package com.service;

import com.pojo.RolePerm;

import java.util.List;

public interface RolePermService {
    List<RolePerm> findAllRolePerm();

    List<String> findPermByRoleId(Integer roleId);

    //    void addRolePerm(Integer roleId, List<RolePerm> list);
    int addRolePerm(RolePerm rolePerm);

    int removeRolePerm(RolePerm rolePerm);
}
