package com.dao;

import com.pojo.CusVisit;

import java.util.List;
import java.util.Map;

public interface CusVisitDao {
    List<CusVisit> selectAllCusVisit();

    List<CusVisit> selectByPage(Map<String, Object> param);

    Integer countAll();

    List<CusVisit> selectVisitByEmpId(Integer id);

    void insertVisit(CusVisit cusVisit);

    void updateVisit(CusVisit cusVisit);

    CusVisit selectById(Integer id);

    void delete(Integer id);

    void deleteByCusId(Integer cusId);
}
