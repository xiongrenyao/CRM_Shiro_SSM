package com.controller;

import com.pojo.CusVisit;
import com.pojo.Customer;
import com.pojo.EmpCus;
import com.pojo.Employee;
import com.service.CusService;
import com.service.CusVisitService;
import com.service.EmpCusService;
import com.service.EmpService;
import com.utils.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("visit")
public class CusVisitController {

    @Resource
    private CusVisitService cusVisitService;
    @Resource
    private EmpCusService empCusService;

    @RequestMapping("showAll")
    @RequiresPermissions("/visit/showAll")
    public String showAll(HttpServletRequest request) {
        List<CusVisit> visitList = cusVisitService.findCustVisit();
        request.setAttribute("visitList", visitList);
        System.err.println(visitList);
        return "visit/showAllVisit";
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String, Object> page(Integer first, Integer maxResult) {
        System.err.println(first + maxResult);
        Integer total = cusVisitService.countAll();
        System.err.println("total:" + total + "==========================");
        List<CusVisit> list = cusVisitService.findByPage(first, maxResult);
        System.err.println("list:" + list + "========================");
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("showById")
    public String showById(HttpServletRequest request, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("LoginUser");
        List<CusVisit> listById = cusVisitService.findVisitByEmpId(emp.getEmpId());
        request.setAttribute("list", listById);
        return "visit/showAllVisit";
    }

    @RequestMapping("add")
    @RequiresPermissions("/visit/add")
    public String add(HttpServletRequest request) {
//        List<Customer> cusList = cusService.findAllCus();

        HttpSession session = request.getSession();
        Employee emp = (Employee) session.getAttribute("LoginUser");
        List<EmpCus> empCusList = empCusService.findByEmpId(emp.getEmpId());
        request.setAttribute("emp", emp);
        request.setAttribute("ecList", empCusList);
        return "visit/addVisit";
    }

    @RequestMapping("save")
    @RequiresPermissions("/visit/save")
    @ResponseBody
    public Result save(Customer cus, Employee emp, CusVisit cusVisit) {
        cusVisit.setCus(cus);
        cusVisit.setEmp(emp);
        System.err.println("CusVisit:" + cusVisit + "++++++++++++++++");
        cusVisitService.addVisit(cusVisit);
        if (null == cusVisit) {
            return Result.error("添加失败");
        }
        return Result.ok();
    }

    @RequestMapping("edit")
    @RequiresPermissions("/visit/edit")
    public String toUpdate(Integer id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Employee emp = (Employee) session.getAttribute("LoginUser");
        List<EmpCus> empCusList = empCusService.findByEmpId(emp.getEmpId());
        CusVisit cusVisit = cusVisitService.findById(id);
        System.err.println(cusVisit + "======================");
        request.setAttribute("visit", cusVisit);
        request.setAttribute("ecList", empCusList);
        return "visit/editVisit";
    }

    @RequestMapping("update")
    @RequiresPermissions("/visit/update")
    @ResponseBody
    public Result update(Customer cus, Employee emp, CusVisit cusVisit) {
        cusVisit.setCus(cus);
        cusVisit.setEmp(emp);
        cusVisitService.modify(cusVisit);
        System.err.println("cusVisit:" + cusVisit + "=============================");
        if (cusVisit == null) {
            return Result.error("修改失败");
        }
        return Result.ok();
    }

    @RequestMapping("delete")
    @RequiresPermissions("/visit/delete")
    @ResponseBody
    public Result remove(Integer id) {
        cusVisitService.remove(id);
        return Result.ok();
    }
}
