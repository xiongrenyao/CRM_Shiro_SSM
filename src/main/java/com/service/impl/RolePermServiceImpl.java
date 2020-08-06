package com.service.impl;

import com.dao.RolePermDao;
import com.pojo.RolePerm;
import com.service.RolePermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("rolePermService")
public class RolePermServiceImpl implements RolePermService {

    @Resource
    private RolePermDao rolePermDao;

    @Override
    public List<RolePerm> findAllRolePerm() {
        return rolePermDao.selectAllRolePerm();
    }

    @Override
    public List<String> findPermByRoleId(Integer roleId) {
        return rolePermDao.selectPermByRoleId(roleId);
    }

    @Override
    public int addRolePerm(RolePerm rolePerm) {
        return rolePermDao.insertRolePerm(rolePerm);
    }

    @Override
    public int removeRolePerm(RolePerm rolePerm) {
        return rolePermDao.deleteRolePerm(rolePerm);
    }

//    @Override
//    public void addRolePerm(Integer roleId, List<RolePerm> list) {
//        rolePermDao.deleteRolePerm(roleId);
//        for (RolePerm rolePerm : list) {
//            rolePermDao.insertRolePerm(rolePerm);
//        }
//    }

//    @Override
//    public void removeRolePerm(int roleId) {
//        rolePermDao.deleteRolePerm(roleId);
//    }
}
