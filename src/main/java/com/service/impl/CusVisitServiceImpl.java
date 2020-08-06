package com.service.impl;

import com.dao.CusVisitDao;
import com.pojo.CusVisit;
import com.service.CusVisitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("cusVisitService")
public class CusVisitServiceImpl implements CusVisitService {

    @Resource
    private CusVisitDao cusVisitDao;

    @Override
    public List<CusVisit> findCustVisit() {
        return cusVisitDao.selectAllCusVisit();
    }

    @Override
    public List<CusVisit> findByPage(int first, int maxResult) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("first", first);
        map.put("maxResult", maxResult);
        return cusVisitDao.selectByPage(map);
    }

    @Override
    public Integer countAll() {
        Integer i = cusVisitDao.countAll();
        System.err.println("i" + i);
        return cusVisitDao.countAll();
    }

    @Override
    public List<CusVisit> findVisitByEmpId(Integer id) {
        return cusVisitDao.selectVisitByEmpId(id);
    }

    @Override
    public void addVisit(CusVisit cusVisit) {
        cusVisitDao.insertVisit(cusVisit);
    }

    @Override
    public void modify(CusVisit cusVisit) {
        cusVisitDao.updateVisit(cusVisit);
    }

    @Override
    public CusVisit findById(Integer id) {
        return cusVisitDao.selectById(id);
    }

    @Override
    public void remove(Integer id) {
        cusVisitDao.delete(id);
    }

    @Override
    public void removeByCusId(Integer cusId) {
        cusVisitDao.deleteByCusId(cusId);
    }
}
