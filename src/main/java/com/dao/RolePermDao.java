package com.dao;

import com.pojo.Perm;
import com.pojo.Role;
import com.pojo.RolePerm;

import java.util.List;

public interface RolePermDao {
    List<RolePerm> selectAllRolePerm();

    List<String> selectPermByRoleId(Integer roleId);

    int insertRolePerm(RolePerm rolePerm);

    int deleteRolePerm(RolePerm rolePerm);

}
