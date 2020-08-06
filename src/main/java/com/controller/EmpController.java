package com.controller;


import com.pojo.Customer;
import com.pojo.EmpCus;
import com.pojo.Employee;
import com.service.CusService;
import com.service.EmpCusService;
import com.service.EmpService;
import com.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Resource
    private CusService cusService;
    @Resource
    private EmpCusService empCusService;
    @Resource
    private EmpService empService;


    @RequestMapping("showAll")
    @RequiresPermissions("/emp/showAll")
    public String showAllEmp(HttpServletRequest request) {
        List<Employee> empList = empService.findAllEmp();
        request.setAttribute("empList", empList);
        return "emp/showAll";
    }

    @RequestMapping("add")
    @RequiresPermissions("/emp/add")
    public String addEmp() {
        return "emp/addEmp";
    }

    @RequestMapping("save")
    @RequiresPermissions("/emp/save")
    @ResponseBody
    public Result saveEmp(Employee employee) {
        String md5Pass = new Md5Hash(employee.getPassword(), "skeye", 2).toString();
        System.out.println("添加的密码:" + md5Pass);
        employee.setPassword(md5Pass);
        empService.addEmp(employee);
        return Result.ok();
    }


    @RequestMapping("delete")
    @RequiresPermissions("/emp/delete")
    @ResponseBody
    public Result removeEmp(Integer id) {
        empService.removeEmp(id);
        return Result.ok();
    }


    @RequestMapping("edit")
    @RequiresPermissions("/emp/edit")
    public String toModifyEmp(Integer id, HttpServletRequest request) {
        Employee emp = empService.findById(id);
        request.setAttribute("emp", emp);
        return "emp/updateEmp";
    }


    @RequestMapping("update")
    @RequiresPermissions("/emp/update")
    @ResponseBody
    public Result modifyEmp(Employee employee) {
        String md5Pass = new Md5Hash(employee.getPassword(), "skeye", 2).toString();
        employee.setPassword(md5Pass);
        empService.modity(employee);
        return Result.ok();
    }

    @RequestMapping("change")
//    @RequiresPermissions("/emp/change")
    public String toChangeCus(Integer empId, HttpServletRequest request) {
        Employee emp = empService.findById(empId);
        List<EmpCus> empCusList = empCusService.findByEmpId(empId);
        List<Employee> empList = empService.findNoMe(empId);
        request.setAttribute("emp", emp);
        request.setAttribute("empCusList", empCusList);
        request.setAttribute("empList", empList);
        return "emp/changeCus";
    }


    @RequestMapping("changed")
    @RequiresPermissions("/emp/changed")
    @ResponseBody
    public Result changeCus(Integer empId) {
        EmpCus empCus = new EmpCus();
        Employee emp = new Employee();
        emp.setEmpId(empId);
        empCus.setEmp(emp);
        empCusService.modify(empCus);
        return Result.ok();
    }

    @RequestMapping("editPass")
    public String editPassword(HttpSession session, HttpServletRequest request) {
        Employee emp = (Employee) session.getAttribute("LoginUser");
        request.setAttribute("emp", emp);
        return "emp/editPassword";
    }


    @RequestMapping("updatePass")
    public String updatePassword(Employee employee, HttpSession session) {
        String md5Pass = new Md5Hash(employee.getPassword(), "skeye", 2).toString();
        employee.setPassword(md5Pass);
        empService.modity(employee);
        if (employee != null) {
            session.removeAttribute("LoginUser");
            return "redirect:/index.jsp";
        } else {
            return "emp/editPassword";
        }
    }
}
