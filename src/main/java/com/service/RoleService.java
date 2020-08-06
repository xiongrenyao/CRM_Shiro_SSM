package com.service;

import com.pojo.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    void modifyRole(Role role);

    List<Role> findAllRole();

    Role findById(Integer roleId);

    void removeRole(Integer roleId);

}
