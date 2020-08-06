package com.service;

import com.pojo.Perm;
import com.utils.Page;

import java.util.List;

public interface PermService {
    void addPerm(Perm perm);

    void removePerm(Integer id);

    void modifyPerm(Perm perm);

    List<Perm> findAllPermByPage(Page page);

    List<Perm> findAllPerm();

    Perm findById(Integer id);

    List<String> findAllPemrByRoleId(Integer roleId);

    int count();
}
