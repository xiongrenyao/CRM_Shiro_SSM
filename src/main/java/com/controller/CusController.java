package com.controller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cus")
public class CusController {

    @Resource
    private CusService cusService;
    @Resource
    private EmpCusService empCusService;
    @Resource
    private EmpService empService;
    @Resource
    private CusVisitService cusVisitService;

    @RequestMapping("showAll")
    @RequiresPermissions("/cus/showAll")
    public String showAll(HttpServletRequest request, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("LoginUser");
        List<EmpCus> list = empCusService.findByEmpId(emp.getEmpId());
        request.setAttribute("cusList", list);
        return "cus/showAllCus";
    }

    @RequestMapping("showAll2")
    @RequiresPermissions("/cus/showAll2")
    public String showAll2(HttpServletRequest request) {
        List<EmpCus> list = empCusService.findAll();
        request.setAttribute("cusList", list);
        return "cus/showAllCus";
    }

    @RequestMapping("showAll3")
    public String showAll3() {
        return "cus/showAllCus2";
    }

    @RequestMapping("add")
    @RequiresPermissions("/cus/add")
    public String add() {
        return "cus/addCus";
    }

    @RequestMapping("save")
    @RequiresPermissions("/cus/save")
    @ResponseBody
    public Result save(Customer customer, HttpSession session) {
        int i = cusService.addCus(customer);
        System.err.println(i + "===========");
        if (i != 0) {
            Customer cus = cusService.findByName(customer.getCusName());
            Employee emp = (Employee) session.getAttribute("LoginUser");
            System.err.println(cus.getCusId() + "=============" + emp.getEmpId());
            EmpCus empCus = new EmpCus();
            empCus.setEmp(emp);
            empCus.setCus(cus);
            empCusService.addEmpCus(empCus);
        }
        return Result.ok();
    }

    @RequestMapping("edit")
    @RequiresPermissions("/cus/edit")
    public String edit(Integer id, HttpServletRequest request) {
        Customer cus = cusService.findById(id);
        request.setAttribute("cus", cus);
        return "cus/editCus";
    }

    @RequestMapping("update")
    @RequiresPermissions("/cus/update")
    @ResponseBody
    public Result update(Customer customer) {
        cusService.modifyCus(customer);
        System.err.println("update:" + Result.ok());
        return Result.ok();
    }

    @RequestMapping("delete")
    @RequiresPermissions("/cus/delete")
    @ResponseBody
    public Result remove(Integer cusId, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("LoginUser");
//        System.err.println(emp.getEmpId()+"========="+cusId);
        Customer cus = cusService.findById(cusId);
        EmpCus empCus = new EmpCus();
        empCus.setCus(cus);
        empCus.setEmp(emp);
        System.err.println(empCus + "==========================");
        empCusService.removeEmpCus(empCus);
        cusVisitService.removeByCusId(cusId);
        cusService.removeCus(cusId);
        return Result.ok();
    }

    @RequestMapping("page")
    @ResponseBody
    public Map<String, Object> showByPage(@RequestParam(name = "first", defaultValue = "0") Integer first,
                                          @RequestParam(name = "maxResult", defaultValue = "0") Integer maxResult) {
        Integer total = cusService.countAll();
        List<Customer> list = cusService.findByPage(first, maxResult);
        System.err.println(list + "==========");
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

//    @RequestMapping("page")
//    @ResponseBody
//    public String showByPage(HttpServletRequest request){
//        int offset = Integer.parseInt(request.getParameter("offset"));
//        int pageSize = Integer.parseInt(request.getParameter("limit"));
//        int currentPage = offset/pageSize+1;
//        BootStrapPage<Customer> bPage = new BootStrapPage<>();
//        Integer total = cusService.countAll();
//        Pages<Customer> pages = cusService.findByPages(new Pages<>(currentPage, pageSize));
//        bPage.setRows(pages.getList());
//        bPage.setTotal(total);
//        return JSONObject.toJSONString(bPage);
//    }

}
