package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.pojo.Role;
import com.service.RoleService;
import com.utils.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Resource
    private RoleService roleService;


    @RequestMapping("showAll")
    @RequiresPermissions("/role/showAll")
    public String show(HttpServletRequest request) {
        List<Role> list = roleService.findAllRole();
        request.setAttribute("list", list);
        return "role/showAll";
    }

    @RequestMapping("add")
    @RequiresPermissions("/role/add")
    public String add() {
        return "/role/addRole";
    }

    @RequestMapping("save")
    @RequiresPermissions("/role/save")
    @ResponseBody
    public Result doAdd(Role role) {
        roleService.addRole(role);
        return Result.ok();
    }

    @RequestMapping("edit")
    @RequiresPermissions("/role/edit")
    public String edit(int roleId, HttpServletRequest request) {
        Role role = roleService.findById(roleId);
        request.setAttribute("role", role);
        return "role/editRole";
    }

    @RequestMapping("update")
    @RequiresPermissions("/role/update")
    @ResponseBody
    public Result doEdit(Role role) {
        System.err.println(role + "=============");
        roleService.modifyRole(role);
        return Result.ok();
    }

    @RequestMapping("delete")
    @RequiresPermissions("/role/delete")
    @ResponseBody
    public Result delete(int roleId) {
        roleService.removeRole(roleId);
        return Result.ok();
    }
}
