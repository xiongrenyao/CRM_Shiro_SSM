package com.controller;

import com.pojo.EmpRole;
import com.pojo.Employee;
import com.pojo.Role;
import com.service.EmpRoleService;
import com.service.EmpService;
import com.service.RoleService;
import com.utils.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("empRole")
public class EmpRoleController {

    @Resource
    private EmpRoleService empRoleService;
    @Resource
    private EmpService empService;
    @Resource
    private RoleService roleService;

//    @RequestMapping("toRoleAss")
//    public String toRoleAss(Integer id, HttpServletRequest request){
//        Employee emp = empService.findById(id);
//        List<Role> roleList = roleService.findAllRole();
//        List<EmpRole> empRoles = empRoleService.findAllEmpRole();
//        System.err.println(empRoles+"====================");
//        Set<Integer> set = new HashSet<>();
//        for (EmpRole empRole:empRoles) {
//            set.add(empRole.getRoleId());
//        }
//        request.setAttribute("emp",emp);
//        request.setAttribute("empRoles",set);
//        request.setAttribute("roleList",roleList);
////        System.err.println(emp+"========================");
////        System.err.println(set+"========================");
////        System.err.println(roleList+"========================");
//        return "empRole/roleAssign";
//    }
//
//    @RequestMapping("roleAss")
//    @ResponseBody
//    public String roleAss(Integer empId, String roles){
//        ArrayList<EmpRole> list = new ArrayList<>();
//        for ( String roleIdStr : roles.split(",")) {
//            list.add(new EmpRole(empId,Integer.parseInt(roleIdStr)));
//        }
//        empRoleService.addEmpRole(empId,list);
//        return "ok";
//    }
//
//    @RequestMapping("delete")
//    @ResponseBody
//    public String remove(Integer empId){
//        empRoleService.removeEmpRole(empId);
//        return "ok";
//    }


    @RequestMapping("editRole")
    @RequiresPermissions("/empRole/editRole")
    public String editRole(Integer id, HttpServletRequest request) {
        EmpRole empRole = empRoleService.findByEmpId(id);
        List<Role> roleList = roleService.findAllRole();
        Role role = roleService.findById(empRole.getRoleId());
        Employee emp = empService.findById(empRole.getEmpId());
        request.setAttribute("role", role);
        request.setAttribute("emp", emp);
        request.setAttribute("roleList", roleList);
        return "empRole/editRole";
    }


    @RequestMapping("updateRole")
    @RequiresPermissions("/empRole/updateRole")
    @ResponseBody
    public Result updateRole(EmpRole empRole) {
        System.err.println(empRole + "===============");
        empRoleService.modifyEmpRole(empRole);
        return Result.ok();
    }
}
