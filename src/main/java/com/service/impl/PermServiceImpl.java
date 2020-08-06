package com.service.impl;

import com.dao.PermDao;
import com.pojo.Perm;
import com.service.PermService;
import com.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("permService")
public class PermServiceImpl implements PermService {

    @Resource
    private PermDao permDao;

    @Override
    public void addPerm(Perm perm) {
        permDao.insertPerm(perm);
    }

    @Override
    public void removePerm(Integer id) {
        permDao.deletePerm(id);
    }

    @Override
    public void modifyPerm(Perm perm) {
        permDao.updatePerm(perm);
    }

    @Override
    public List<Perm> findAllPermByPage(Page page) {
        return permDao.selectAllPermByPage(page);
    }

    @Override
    public List<Perm> findAllPerm() {
        return permDao.selectAllPerm();
    }

    @Override
    public Perm findById(Integer id) {
        return permDao.selectById(id);
    }

    @Override
    public List<String> findAllPemrByRoleId(Integer roleId) {
        return permDao.selectAllPemrByRoleId(roleId);
    }

    @Override
    public int count() {
        return permDao.count();
    }
}
