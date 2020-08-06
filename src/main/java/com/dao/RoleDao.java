package com.dao;

import com.pojo.Role;

import java.util.List;

public interface RoleDao {

    void insertRole(Role role);

    void updateRole(Role role);

    List<Role> selectAllRole();

    Role selectById(int roleId);

    void deleteRole(int roleId);


}
