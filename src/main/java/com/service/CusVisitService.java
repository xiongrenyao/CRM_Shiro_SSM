package com.service;

import com.pojo.CusVisit;

import java.util.List;
import java.util.Map;

public interface CusVisitService {
    List<CusVisit> findCustVisit();

    List<CusVisit> findByPage(int first, int maxResult);

    Integer countAll();

    List<CusVisit> findVisitByEmpId(Integer id);

    void addVisit(CusVisit cusVisit);

    void modify(CusVisit cusVisit);

    CusVisit findById(Integer id);

    void remove(Integer id);

    void removeByCusId(Integer cusId);
}
