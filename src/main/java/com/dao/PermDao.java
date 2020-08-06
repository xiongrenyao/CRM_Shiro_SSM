package com.dao;

import com.pojo.Perm;
import com.utils.Page;

import java.util.List;

public interface PermDao {
    void insertPerm(Perm perm);

    void deletePerm(int id);

    void updatePerm(Perm perm);

    List<Perm> selectAllPermByPage(Page page);

    List<Perm> selectAllPerm();

    Perm selectById(int id);

    List<String> selectAllPemrByRoleId(Integer roleId);

    int count();
}
