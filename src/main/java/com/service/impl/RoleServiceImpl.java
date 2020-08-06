package com.service.impl;


import com.dao.RoleDao;
import com.pojo.Role;
import com.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleSerivce")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        roleDao.insertRole(role);
    }

    @Override
    public void modifyRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public List<Role> findAllRole() {
        return roleDao.selectAllRole();
    }

    @Override
    public Role findById(Integer roleId) {
        return roleDao.selectById(roleId);
    }

    @Override
    public void removeRole(Integer roleId) {
        roleDao.deleteRole(roleId);
    }


}
